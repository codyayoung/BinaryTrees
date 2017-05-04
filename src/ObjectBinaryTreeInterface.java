/**
 * Created by masterchef13 on 5/4/17.
 */
public interface ObjectBinaryTreeInterface {
	public ObjectTreeNode getRoot();
	public void setleftChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void setrightChild(ObjectTreeNode parent, ObjectTreeNode r);
	public void insertBST(Object o);
	public void insertBSTDup(Object o);
	public ObjectTreeNode searchBST(Object o);
	public void preTrav(ObjectTreeNode tree);
	public void inTrav(ObjectTreeNode tree);
	public void postTrav(ObjectTreeNode tree);
	public void delete(Object o);
}
