/**
 * Created by masterchef13 on 5/4/17.
 */
public interface TreeComparable extends ObjectBinaryTreeInterface {
    public int compareTo (Object o);
    public void visit();
    public void operate(Object r);
}
