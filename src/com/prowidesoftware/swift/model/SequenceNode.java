package com.prowidesoftware.swift.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Node that identifies a sequence inside a message.
 * Messages may define an arbitrary amount of sequences and nested subsequences.
 * These structures are modeled here as a tree.
 * 
 * @since 6.3
 */
public class SequenceNode {
	private final String name;
	private final List<SequenceNode> children = new ArrayList<SequenceNode>();
	private final SequenceNode parent;
	
	private SequenceNode(final String name, final SequenceNode parent) {
		this.name = name;
		this.parent = parent;
	}
	
	/**
	 * get the name of this sequence
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds a sequence to this node
	 * @param name the name of the sequence to add
	 * @return the newly created sequence
	 */
	public SequenceNode addChild(String name) {
		final SequenceNode o = new SequenceNode(name, this);
		this.children.add(o);
		return o;
	}
	
	/**
	 * Creates a root node. this must be the main entry point of all sequences
	 */
	public static SequenceNode newRootNode() {
		return new SequenceNode("main", null);
	}

	public SequenceNode getParent() {
		return parent;
	}
}
