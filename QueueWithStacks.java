package implementaqueuewithtwostacks;

import java.util.Stack;

public class QueueWithStacks <E> {

	private Stack<E> addStack;
	private Stack<E> deleteStack;

	public QueueWithStacks(){
		addStack = new Stack<>();
		deleteStack = new Stack<>();
	}

	public void enqueue(E value){
		addStack.push(value);
	}

	public E dequeue(){

		if(deleteStack.empty()){

			assert !addStack.empty(): "There are no values in the queue";
			
			moveValuesToDeleteStack();

		}

		return deleteStack.pop();
	}

	private void moveValuesToDeleteStack(){

		while(!addStack.empty()) {
			deleteStack.push(addStack.pop());
		}
	}
}