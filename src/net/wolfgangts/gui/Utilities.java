package net.wolfgangts.gui;

public class Utilities
{
	/**
	 * Finds strF in strS, returns how many times found
	 * 
	 * @param strS
	 *            String to be checked
	 * @param strF
	 *            String to be found
	 * @return amount of instances found
	 */
	public static int instancesOf(String strS, String strF)
	{
		String str = strS;
		String findStr = strF;
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1)
		{

			lastIndex = str.indexOf(findStr, lastIndex);

			if (lastIndex != -1)
			{
				count++;
				lastIndex += findStr.length();
			}
		}

		return count;
	}
}
