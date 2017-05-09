/**
 * Created by masterchef13 on 5/4/17.
 */
public interface ObjectTreeNodeInterface {
	public void setInfo(Object o);
	public Object getInfo();
	public void setLeft(ObjectTreeNode p);
	public ObjectTreeNode getLeft();
	public void setRight(ObjectTreeNode p);
	public ObjectTreeNode getRight();
	public void visit();
}
