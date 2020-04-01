import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;

    public VectorHeap(){
        data = new Vector<E>();
    }

    protected static int parent(int i){
        return (i - 1) / 2;
    }
    
    protected static int left(int i){
        return 2 * i + 1;
    }

    protected static int right(int i){
        return (2 * i + 1) + 1;
    }
    
    protected void percolateUp(int leaf){
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    public void add(E value){
        data.add(value);
        percolateUp(data.size() - 1);
    }

    protected void pushDownRoot(int root){
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }
    
    public E remove() {
    	
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }
    
    public E getFirst() {
    	
        return data.get(0);
    }

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}