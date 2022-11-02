package bignumber;

import linkedList.LinkedList;
import linkedList.LinkedListIterator;
import linkedList.interfaces.ILinkedList;
import linkedList.interfaces.ILinkedListIterator;

public class BigNumberImpl implements BigNumber {

    private ILinkedList<Integer> digits;

    public BigNumberImpl() {
        this.digits = new LinkedList<Integer>();
    }

    public BigNumberImpl(String number) {
        this.digits = new LinkedList<Integer>();
        for (int x = 0; x < number.length(); x++) {
            int num = Integer.parseInt(number);
            shiftLeft(1);
            addDigit(num);
        }
    }

    public BigNumberImpl(BigNumber number) {
        // hack
        var it = ((BigNumberImpl) number).getIterator();

        while(it.hasNext()) {
           int temp = it.next();
           shiftLeft(1);
           addDigit(temp);
        }
    }

    @Override
    public int length() {
        return digits.length();
    }

    @Override
    public void shiftLeft(int num_shifts) {
        for (int x = 0; x < num_shifts; x++) {
            digits.addAtHead(0);
        }
    }

    @Override
    public void shiftRight(int num_shifts) {
        for (int x = 0; x < num_shifts; x++) {
            digits.remove(0);
        }
    }

    @Override
    public void addDigit(int digit) {
        ILinkedListIterator<Integer> it = digits.iterator();

        //int tempTotal = digit + getDigitAt(digits.length() - 1);
        int tempTotal = digit + getDigitAt(0);

        if (tempTotal > 9) {
            it.set(0);
            handleCarry(it);
        } else {
            it.set(tempTotal);
        }
    }

    private void handleCarry(ILinkedListIterator<Integer> it) {
        int tempTotal = it.prev();
        if (tempTotal > 9) {
            it.set(0);
            handleCarry(it);
        } else {
            it.set(tempTotal);
        }
    }

    @Override
    public int getDigitAt(int position) {
        return digits.get(position);
    }

    @Override
    public BigNumber copy() {
        return new BigNumberImpl();
    }

    @Override
    public BigNumber add(BigNumber number) {
        BigNumber newNumber = new BigNumberImpl();
        int index = 0;
        int newDigit;
        for (int digit : digits) {
            newDigit = digit + getDigitAt(index);
            newNumber.shiftLeft(1);
            newNumber.addDigit(newDigit);
            index++;
        }

        return newNumber;
    }

    @Override
    public int compareTo(BigNumber o) {
        return this.toString().compareTo(o.toString());
    }

    public ILinkedListIterator<Integer> getIterator() {
        return digits.iterator();
    }

    @Override
    public String toString() {
        ILinkedListIterator<Integer> it = digits.iterator();
        StringBuilder sb = new StringBuilder(it.next().toString());

        while(it.hasNext()) {
           sb.append(it.next().toString());
        }
       return sb.toString();
    }
}
