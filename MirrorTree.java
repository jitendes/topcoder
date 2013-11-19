public void mirrorTree(Node t) {
	if (t == null) return;
	mirrorTree(t.left);
	mirrorTree(t.right);
	Node temp = t.left;
	t.left = t.right;
	t.right = temp;
	return;
}
