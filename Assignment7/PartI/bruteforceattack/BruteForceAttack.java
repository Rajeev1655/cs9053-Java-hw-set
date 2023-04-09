package bruteforceattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.util.*;

public class BruteForceAttack extends Thread {

	public int index;
	public int len;
	private int start;
	private int end;
	public int numFound = 0;
	public int numThreads = 0;
//	public final static Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
	static final char startLower = 'a';
	static final char startUpper = 'A';
	static final char startNumber = '0';
	static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w','x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

	BruteForceAttack(int index, int len, int start, int end, int numThreads) {
		this.index = index;
		this.len = len;
		this.start = start;
		this.end = end;
		this.numThreads = numThreads;
		System.out.println("Thread " + index + " is created.");
	}

	@Override
	public void run() {
		System.out.println("Thread " + index + " is running.");
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		byte[] pass = generatePass(len, index, numThreads);

//		pass = new byte[]{'a', 'a', 'a', 'a', 'n'};
		for (long j = start ; j < end ;j++) {
			int v = (int)(j % 26L);
			if ((v == 0) && (j!=0)) {

				pass[0] = startLower;
				for (int k = 1;k<pass.length ;k++) {
					if (pass[k] == 'z') {
						if (k != pass.length-1) {
							pass[k] = startLower;
							continue;
						} else {
							break;
						}
					} else {
						int val = getInt((char)pass[k]);
						val++;
						pass[k] = (byte)letters[val];
						break;
					}
				}
			} else {
				pass[0] = (byte)letters[v];
			}

			byte[] encodedhash = digest.digest(pass);

			String hashpass = BruteForceAttack.bytesToHex(encodedhash);
//			synchronized (passwordSet) {
				if (passwordSet.contains(hashpass)) {
					String passString = new String(pass);
					System.out.println("found password " + passString);
					numFound++;
//					System.out.println("found " + numFound + " passwords in thread " + name);
//				}
			}
		}
	}

	// generate a password of length len
	public static byte[] generatePass(int len, int index, int numberThreads) {
		byte[] pass = new byte[len+1];
		byte[] base = new byte[len];
		pass[0] = 'z';
		for (int k = 1;k<pass.length ;k++) {
			pass[k] = startLower;
		}
		base = divide26Base(pass, numberThreads);
		pass = new byte[len];
		Arrays.fill(pass, (byte)startLower);
		for (int k = 0;k<index ;k++) {
			pass = addBase26(pass, base);
		}
		// reverse the password
		for (int j= 0; j < pass.length / 2; j++) {
			byte temp = pass[j];
			pass[j] = pass[pass.length - j - 1];
			pass[pass.length - j - 1] = temp;
		}

		return pass;
	}

	public static byte[] divide26Base(byte[] pass, int len) {
		byte[] result = new byte[pass.length-1];
		// divide the base 26 number by len
		for (int i = 0; i < pass.length-1; i++) {
			int val = getInt((char)pass[i]);
			if (val % len != 0) {
				val = val / len;
				val++;
			}else {
				val = val / len;
			}
			result[i] = (byte)letters[val];
		}
		return result;
	}

	public static byte[] addBase26(byte[] first, byte[] second) {
		byte[] result = new byte[first.length];
		for (int i = 0; i < first.length; i++) {
			int val = getInt((char)first[i]) + getInt((char)second[i]);
			if (val > 61) {
				val = val - 62;
			}
			result[i] = (byte)letters[val];
		}
		return result;
	}

	public static char getChar(int i) {
		return letters[i];
	}
	
	public static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static int getInt(char c) {
		if ((c >= 'a') && (c <= 'z')) {
			return c - 'a';
		} else if ((c >= 'A') && (c <= 'Z')) {
			return 26 + (c - 'A');
		} else if ((c >= '0') && (c <= '9')) {
			return 52 + (c - '0');
		} else {
			return 0;
		}
	}
	
	public static Set<String> hashedpasswords(String filename) {
		Set<String> hashSet = new HashSet<String>();
		try {
			FileReader fr = new FileReader("hashedpassword.txt");
			BufferedReader br = new BufferedReader(fr);
			String inline = br.readLine();
			while (inline != null) {
				hashSet.add(inline);
				inline = br.readLine();
			}
		} catch (Exception e) {
			
		}
		return hashSet;
		
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Time startTime = new Time(System.currentTimeMillis());
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		int numfound = 0;
		int len = 6;
		int numThreads = 16; // can only be even numbers
		ArrayList<BruteForceAttack> threads = new ArrayList<BruteForceAttack>();
		
		double max = Math.pow(26, len);

		// divide work
		int workPerThread = (int)max / numThreads;
		int start = 0;
		int end = workPerThread;



		// create threads
		for (int i = 0; i < numThreads; i++) {
			BruteForceAttack thread = new BruteForceAttack(i, len, start, end, numThreads);
			thread.start();
			threads.add(thread);
			start = end;
			if (end + workPerThread < max) {
				end += workPerThread;
			} else {
				end = (int)max;
			}
		}

		// wait for all threads to finish
		boolean done = false;
		while (!done){
			done = true;
			for (int i = 0; i < numThreads; i++) {
				if (threads.get(i).isAlive()) {
					done = false;
					break;
				}
			}
		}
		for (int i = 0; i < numThreads; i++) {
			numfound += threads.get(i).numFound;
		}
		// print out results
		Time endTime = new Time(System.currentTimeMillis());
		System.out.println("found " + numfound + " out of " + passwordSet.size());
		System.out.println("done in: " + (endTime.getTime() - startTime.getTime()) + " ms");
	}
}
