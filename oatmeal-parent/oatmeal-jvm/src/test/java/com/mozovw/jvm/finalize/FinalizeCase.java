package com.mozovw.jvm.finalize;
public class FinalizeCase {

    @SuppressWarnings("unused")
	private static Block holder = null;

    public static void main(String[] args) throws Exception {
        holder = new Block();
        holder = null;
        System.gc();
        //System.in.read();
    }

    static class Block {
        byte[] _200M = new byte[20*1024*1024];
        
        @Override
        protected void finalize() throws Throwable {
            System.out.println("invoke finalize");
        }
    }
}