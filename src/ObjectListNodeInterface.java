/**
 * Interface for ObjectListNode objects.
 * @author Cody Young
 * @version 4/11/17
 */
public interface ObjectListNodeInterface {
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}
