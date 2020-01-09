import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BinaryTree<E> implements MyCollection<E>, Iterable<E> {

	/*
	 * Private class of nodes.
	 */
	private static class Node<T> {

		private T value;
		private Node<T> left, right;

		private Node(T value, Node<T> left, Node<T> right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		/*
		 * Auxiliary method to compute the height of the tree from this node. Much
		 * easier if it is static.
		 */
		private static int height(Node<?> node) {
			if (node == null){
				return 0;
			} else {
				return 1 + Math.max(height(node.left), height(node.right));
			}
		}

		/*
		 * Auxiliary method to add an element in the subtree from this node. Since we
		 * need T, we can't use a static method.
		 */
		private void add(T t) {
			if (left == null)
				left = new Node<T>(t, null, null);
			else if (right == null)
				right = new Node<T>(t, null, null);
			else if (height(left) <= height(right))
				left.add(t);
			else
				right.add(t);
		}

		/*
		 * Auxiliary method for checking whether an element occurs in the subtree from
		 * this node. Since we use T, this can't be static.
		 */
		private boolean contains(T t) {
			return (value.equals(t) || ((left != null) && left.contains(t)) || ((right != null) && right.contains(t)));
		}

		/*
		 * Auxiliary method for computing the size of the subtree from this node. Much
		 * easier if it is static.
		 */
		private static int size(Node<?> node) {
			if (node == null){
				return 0;
			} else {
				return 1 + size(node.left) + size(node.right);
			}
		}

		/*
		 * Makes a copy of the subtree from this node. Again, static is easier.
		 */
		private static <F> Node<F> copy(Node<F> node) {
			if (node == null)
				return null;
			else
				return new Node<F>(node.value, copy(node.left), copy(node.right));
		}

		/*
		 * Reflects the subtree starting from a given node. Again, static is easier.
		 */
		private static <F> void mirror(Node<F> node) {
			if (node != null) {
				mirror(node.left);
				mirror(node.right);
				Node<F> temp = node.left;
				node.left = node.right;
				node.right = temp;
			}
		}

		/*
		 * Returns a textual representation of the subtree from a node. Much easier if
		 * it is static.
		 */
		private static <F> String toString(Node<F> node) {
			if (node == null)
				return "[]";
			else
				return "[" + node.value + "; " + toString(node.left) + "; " + toString(node.right) + "]";
		}

		/*
		 * Checks whether the trees starting from two nodes are equals.
		 */
		private static <F, G> boolean equals(Node<F> n1, Node<G> n2) {
			if (n1 == null)
				return (n2 == null);
			else
				return ((n1.value.equals(n2.value)) && equals(n1.left, n2.left) && equals(n1.right, n2.right));
		}

		/*
		 * Returns a hash of the subtree from this node.
		 */
		public int hashCode() {
			return Objects.hash(value, left, right);
		}

	}

	/*
	 * Inner class implementing the Iterator<E> interface as a pre-order traversal.
	 */
	private class PreOrderIterator implements Iterator<E> {

		private Stack<Node<E>> nextNodes;

		public PreOrderIterator() {
			nextNodes = new Stack<Node<E>>();
			if (root != null){
				nextNodes.add(root);
			}
			
		}

		public boolean hasNext() {
			return (!nextNodes.isEmpty());
		}

		/*
		 * We get the next node from the stack, return the value, and push the left and
		 * right children in the stack.
		 */
		public E next() {
			if (!hasNext()){
				throw new NoSuchElementException("No more elements.");
			}
			Node<E> next = nextNodes.top();
			E value = nextNodes.top().value;
			nextNodes.pop();
			if (next.right != null){
				nextNodes.add(next.right);
			}
			if (next.left != null){
				nextNodes.add(next.left);
			}
			return value;
		}

	}

	/*
	 * Inner class implementing the Iterator<E> interface as an in-order traversal.
	 * The implementation destroys the original nodes, so we need to copy them.
	 */
	private class InOrderIterator implements Iterator<E> {

		private Stack<Node<E>> nextNodes;

		public InOrderIterator() {
			nextNodes = new Stack<Node<E>>();
			if (root != null){
				nextNodes.add(Node.copy(root));
			}
		}

		public boolean hasNext() {
			return (!nextNodes.isEmpty());
		}

		/*
		 * We get the next node from the stack, separate its left child, and push the
		 * child and the node back into the stack. Then we return the value.
		 */
		public E next() {
			if (!hasNext()){
				throw new NoSuchElementException("No more elements.");
			}
			Node<E> next = nextNodes.top();
			while (next.left != null) {
				nextNodes.add(next.left);
				next.left = null;
				next = nextNodes.top();
			}

			E value = nextNodes.top().value;
			nextNodes.pop();
			if (next.right != null){
				nextNodes.add(next.right);
			
			}
			return value;
		}

	}

	/*
	 * Inner class implementing the Iterator<E> interface as a post-order traversal.
	 * Again, the implementation destroys the original nodes, so we need to copy
	 * them.
	 */
	private class PostOrderIterator implements Iterator<E> {

		private Stack<Node<E>> nextNodes;

		public PostOrderIterator() {
			nextNodes = new Stack<Node<E>>();
			if (root != null){
				nextNodes.add(Node.copy(root));
			}
		}

		public boolean hasNext() {
			return (!nextNodes.isEmpty());
		}

		/*
		 * We get the next node from the stack and separately add both children into the
		 * stack until we reach a leaf. Then we return the value.
		 */
		public E next() {
			if (!hasNext()){
				throw new NoSuchElementException("No more elements.");
			}
			Node<E> next = nextNodes.top();
			while ((next.left != null) || (next.right != null)) {
				if (next.right != null){
					nextNodes.add(next.right);
				}

				next.right = null;
				if (next.left != null){
					nextNodes.add(next.left);
				
				}
				next.left = null;
				next = nextNodes.top();
			}

			E value = nextNodes.top().value;
			nextNodes.pop();
			return value;
		}

	}

	/*
	 * We have a pointer to the root.
	 */
	private Node<E> root;

	/*
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
		root = null;
	}

	/*
	 * No getters or setters.
	 */

	/*
	 * We first implement the MyCollection<E> interface.
	 */
	public void add(E e) {
		if (root == null){
			root = new Node<E>(e, null, null);
		} else{
			root.add(e);
		}

	}

	public void clear() {
		root = null;
	}

	public boolean contains(E e) {
		return ((root != null) && root.contains(e));
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public int size() {
		return Node.size(root);
	}

	/*
	 * Now we implement the iterable interface.
	 */
	public Iterator<E> iterator() {
		return new InOrderIterator();
	}

	/*
	 * Returns the element at the root of this tree. Assumes the tree is non-empty.
	 */
	public E root() {
		return root.value;
	}

	/*
	 * Returns the left subtree of this tree.
	 */
	public BinaryTree<E> left() {
		BinaryTree<E> child = new BinaryTree<E>();
		child.root = Node.copy(root.left);
		return child;
	}

	/*
	 * Returns the right subtree of this tree.
	 */
	public BinaryTree<E> right() {
		BinaryTree<E> child = new BinaryTree<E>();
		child.root = Node.copy(root.right);
		return child;
	}

	/*
	 * Returns the height of this tree.
	 */
	public int height() {
		return Node.height(root);
	}

	/*
	 * Reflects this tree.
	 */
	public void mirror() {
		Node.mirror(root);
	}

	/*
	 * Returns a pre-order iterator for this tree.
	 */
	public Iterator<E> preIterator() {
		return new PreOrderIterator();
	}

	/*
	 * Returns an in-order iterator for this tree.
	 */
	public Iterator<E> inIterator() {
		return new InOrderIterator();
	}

	/*
	 * Returns a post-order iterator for this tree.
	 */
	public Iterator<E> postIterator() {
		return new PostOrderIterator();
	}

	/*
	 * Returns a textual representation of this binary tree.
	 */
	public String toString() {
		return Node.toString(root);
	}

	/*
	 * Returns a copy of this binary tree.
	 */
	public BinaryTree<E> copy() {
		BinaryTree<E> copy = new BinaryTree<E>();
		copy.root = Node.copy(root);
		return copy;
	}

	/*
	 * Checks whether this binary tree is equal to another object.
	 */
	public boolean equals(Object other) {
		if (!(other instanceof BinaryTree)){
			return false;
		} else {
			BinaryTree<?> otherTree = (BinaryTree<?>) other;
			return (Node.equals(this.root, otherTree.root));
		}
	}

	/*
	 * Returns a hash of this binary tree.
	 */
	public int hashCode() {
		return Objects.hash(root);
	}

	/*
	 * Basic testing.
	 */
	public static void main(String[] args) {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.add(1);
		t.add(2);
		t.add(3);
		System.out.println("Tree: " + t);
		System.out.println("Root: " + t.root());
		System.out.println("Size: " + t.size());
		System.out.println("Contains 1: " + t.contains(1));
		System.out.println("Contains 2: " + t.contains(2));
		System.out.println("Contains 4: " + t.contains(4));
		System.out.println("Empty? " + t.isEmpty());
		t.clear();
		System.out.println("Size: " + t.size());
		System.out.println("Empty? " + t.isEmpty());
		t.add(1);
		t.add(2);
		t.add(3);
		t.add(4);
		System.out.println("Tree: " + t);
		
		for (Integer i : t){
			System.out.println("Iterating: " + i);
		}

		System.out.println("Tree: " + t);
		t.mirror();
		System.out.println("Tree: " + t);
	}

}
