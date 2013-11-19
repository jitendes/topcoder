public void mirrorTree(Node t) {
		if (t == null)
			return;
		Node temp = null;
		mirrorTree(t.left);
		mirrorTree(t.right);
		temp = t.left;
		t.left = t.right;
		t.right = temp;
		return;
}
