package com.example.hao.myapplication;

import android.util.Log;

/**
 * Created by Hao on 12/16/14.
 * linkedList: List
 * ops: insertElem, getElem, delElem, getLength, searchElem
 */
public class linkedList {
    int length;
    class listNode {
        int data;
        //int index;
        listNode next;
        listNode previous;

        listNode(int data) {
            this.data = data;
        }
    }
    listNode header, tail, iterator;

    linkedList() {
        length = 0;
        header = new listNode(0);
        tail = new listNode(0);
        iterator = new listNode(0);
        header.next = tail;
        //make it circle: easy to travel from tail
        header.previous = tail;
        tail.previous = header;
        tail.next = header;
    }

    boolean iterate(int index) {
        try {
            if (index > length || index < 1) {
                Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
                return false;
            }
            if (index > length / 2) {
                iterator.previous = tail.previous;
                for (int i = length + 1; i > index - 1; i--) {
                    iterator.next = iterator.previous.next; // point to the current node
                    iterator.previous = iterator.previous.previous;
                }
            } else {
                iterator.next = header.next;
                for (int i = 0; i <= index; i++) {
                    iterator.previous = iterator.next.previous;
                    iterator.next = iterator.next.next;
                }
            }
        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            throw exception;
        } finally {
            return false;
        }

    }

    boolean insertElem(int index, int data) {
        try {
            iterate(index);
            listNode newNode = new listNode(data);
            newNode.previous = iterator.previous;
            newNode.previous = iterator.previous.next;
            iterator.previous.next.previous = newNode;
            iterator.previous.next = newNode;
            return true;

        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            throw exception;
        } finally {
            return false;
        }
    }

    boolean insertElem(int data) {
        /* poly
        * index not specified, default to the last element*/
        try {
            listNode newNode = new listNode(data);
            tail.previous.next = newNode;
            tail.previous = newNode;
            return true;
        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
        } finally {
            return false;
        }

    }

    int getElem(int index) {
        iterate(index);
        return iterator.previous.next.data;
    }
}
