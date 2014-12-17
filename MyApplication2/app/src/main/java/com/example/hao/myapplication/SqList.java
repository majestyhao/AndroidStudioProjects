package com.example.hao.myapplication;

import android.util.Log;


/**
 * Created by Hao on 12/15/14.
 * Sequential List: List
 * + getElem; low overhead of each node - insert & del; space wasting
 * implement by Array
 * index starts from 1
 * ops: getElem (O(1)), insertElem (O(n)), delElem (O(n)), printList (O(n)), getLength, searchElem
 * leverage Activity and Intent to show error info, rather call system exceptions
 */
public class SqList {
    int data[];
    int length;
    int MAXSIZE; // maybe there is a way to optimize it, rather than linkedList

    SqList(int MAXSIZE) {
        /* Constructor */
        length = 0;
        this.MAXSIZE = MAXSIZE;
        for (int i : data = new int[MAXSIZE]) {
            data[i] = 0;
        }
    }

    int getElem(int index) {
        try {
            if (index > length || index < 1) {
                Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
                System.exit(0);
            }
                return data[index - 1];

        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            throw exception;
        } catch (IndexOutOfBoundsException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        }
    }

    boolean insertElem(int index, int elem) {
        try {
            if (index > length || index < 1) {
                Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
                System.exit(1);
            }
            if (length == MAXSIZE) {
                MAXSIZE++;
                int tmp[] = new int[MAXSIZE];
                for (int i = 0; i <= MAXSIZE - 1; i++) {
                    tmp[i] = data[i];
                }
                data = tmp;
            } else {
                for (int i = length - 1; i >= index - 1; i--) {
                    data[i + 1] = data[i];
                }
                data[index - 1] = elem;
                length++;
            }
            return true;
        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            throw exception;
        } catch (IndexOutOfBoundsException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        } finally {
            return false;
        }
    }

    int getLength() {
        return length;
    }

    int delElem(int index) {
        /* del the element and return the value */
        try {
            if (index  > length || length == 0) {
                Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
                System.exit(0);
            }
            int tmp = data[index - 1];
            for (int i = index - 1; i < length - 1; i++) {
                data[i] = data[i + 1];
            }
            length--;
            return tmp;
        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            throw exception;
        } catch (IndexOutOfBoundsException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        }
    }

    void printList() {
        /* print the list in the logcat */
        try {
            if (length == 0) {
                Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            } else {
                for (int i = 0; i < length; i++) {
                    Log.d(UsualStrings.LOG_TAG, String.valueOf(data[i]));
                }
            }
        } catch (NullPointerException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.NULL_POINTER);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            throw exception;
        } catch (IndexOutOfBoundsException exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.OUT_BOUNDARY);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        } catch (Exception exception) {
            Log.d(UsualStrings.LOG_TAG, UsualStrings.UNKNOWN_EXCEPTION);
            Log.d(UsualStrings.LOG_TAG, exception.getMessage());
            System.exit(0);
            throw exception;
        }
    }

    int searchElem(int elem) {
        // TODO
        return 0;
    }

}
