package com.chandan.designproblems.DesignMemoryAllocator2502;

class Allocator1 { // Brute force O(n^2)

    private int[] memory;

    public Allocator1(int n) {
        memory = new int[n];
    }

    public int allocate(int size, int mID) {
        for(int i = 0; i <= memory.length - size; i++) {
            int canUse = 0;
            for(int j = i; j < i + size && j < memory.length; j++) {
                if(memory[j] != 0) {
                    canUse = 1;
                    break;
                }
            }
            if(canUse != 1) {
                for(int j = i; j < i + size; j++) {
                    memory[j] = mID;
                }
                return i;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int freed = 0;
        for(int i = 0; i < memory.length; i++) {
            if(memory[i] == mID) {
                memory[i] = 0;
                freed++;
            }
        }
        return freed;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */
