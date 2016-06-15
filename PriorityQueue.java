public boolean offer(E e){
	if(e==NULL)
		throw new NullPointerException;
	modCount++;
	int i=size;
	if(i>queue.length)
		grow(i+1);  //自动扩容 
	size=i+1;
	if(i==0)
		queue[0]=e;
	else 
		shiftUp(i,e);
	return true;
}
//从k指定的位置开始，将x逐层与当前点的parent进行比较并交换，直到满足x >= queue[parent]为止
private void shiftUp(int k,E x){
	while(k>0){
		int parent=(k-1)>>>1;  //parent=(nodeNo-1)/2
		Object e=queue[parent];
		if(comparator.compare(x,(E) e)>=0)
			break;
		queue[k]=e;
		k=parent;
	}
	queue[k]=x;
}
public E poll(){
	if(size==0)
		return null;
	int s=--size;
	modCount++;
	E result=(E)queue[0];
	E x=(E)queue[s];
	queue[s]=null;
	if(s!=0)
		shiftDown(0,x);
	return result;
}

private void shiftDown(int k,E x){
	int half=size>>>1;
	while(k<half){
		int child=(k<<1)+1;  //leftNo=parentNo*2+1
		Object c=queue[child];
		int right=child+1;
		if(right<size &&
			comparator.compare((E)c,(E) queue[right])>0)
			c=queue[child=right];
		if(comparator.compare(x,(E) c)<=0)
			break;
		queue[k]=c;
		k=child;
	}
	queue[k]=x;
}
public E peek(){
	if(size==0)
		return null;
	return queue[0];
}
