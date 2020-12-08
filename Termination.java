package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Termination {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try  
		{
			File file = new File("Source/termination.txt");
			FileReader fr=new FileReader(file);  
			BufferedReader br=new BufferedReader(fr);  
//			StringBuffer sb=new StringBuffer();  
			String line;
			List<String> list = new ArrayList<String>();
			while((line=br.readLine())!=null)  
			{
				list.add(line);
			}
			fr.close(); 
			for(int i=0;i<list.size();i++)
			{
				String sb = new String("");
				if(list.get(i).contains("Employeeid        : ") || list.get(i).contains("Enabled           : ") || list.get(i).contains("DistinguishedName :") || list.get(i).contains("SempraLicensing   :") || list.get(i).contains("DisplayName       :"))
				{
					String[] id;
					String[] e;
					if(list.get(i).contains("Employeeid        : "))
					{
						System.out.println();
						id = list.get(i).split(":");
						sb = sb + id[1].trim();
						sb = sb + ",";
					}
					if(list.get(i).contains("Enabled           : "))
					{
						e = list.get(i).split(":");
						sb = sb + e[1].trim();
						sb = sb + ",";
					}
						
					if(list.get(i).contains("OU=Disabled"))
					{
						sb = sb + "Disabled";
						sb = sb + ",";
					}
					else if(list.get(i).contains("OU="))
					{
						sb = sb + "Enabled";
						sb = sb + ",";
					}
						
					if(list.get(i).length() == 19)
					{
						sb = sb + "Clear";
						sb = sb + ",";
					}
					else if(list.get(i).length() > 19 && list.get(i).contains("SempraLicensing") && list.get(i).contains(":"))
					{
						sb = sb + "Not Clear";
						sb = sb + ",";
					}
					if(list.get(i).contains("TERM-") && !list.get(i).contains("CN=TERM"))
					{
						sb = sb + "TERM*";
						sb = sb + ",";
					}
					else if(list.get(i).contains("DisplayName") && list.get(i).contains(":"))
					{
						sb = sb + "NOT TERM*" + ",";
					}
					System.out.print(sb);
				}
				else if(list.get(i).contains("PS C:\\Windows\\system32> get-aduser -f {") && list.get(i+1).contains("PS C:\\Windows\\system32> get-aduser -f {") && i<list.size()-1)
				{
					System.out.println();
					System.out.print(list.get(i).substring(55,60));
				}
				else
				{
					continue;
				}
				
			}
//			System.out.print(sb.toString());
		}catch (Exception e) {
			e.printStackTrace(); 
		}
	}

}
