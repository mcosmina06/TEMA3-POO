import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException, IOException {
		TeamFactory type_team = new TeamFactory();
		ArrayList <Team> T = new ArrayList<Team>();
		int i;
		try {
	    	//fisierul de scriere
	    	File fileWriter = new File(args[3]);
			FileWriter output = new FileWriter(fileWriter);
			        
			//fisierul de citire
			FileReader fileReader1 = new FileReader(args[1]);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);		        
			
			/**
			 * string pentru stocarea fiecarei linii din fisier
			 */
			 String s;
			 
			 /**
			  * vector pentru s
			  */
			 String [] r;
			 
			 while ((s = bufferedReader1.readLine()) != null) {
				 r = s.split(", ");
				 if(r[0].equals("football")){
					 T.add(type_team.getTeam("football"));
					 T.get(T.size() - 1).set_name(r[1]);
					 T.get(T.size() - 1).set_gender(r[2]);
					 T.get(T.size() - 1).set_nb(Integer.parseInt(r[3]));
					 int ok = Integer.parseInt(r[3]);
					 while(ok != 0) {
						 s = bufferedReader1.readLine();
						 r = s.split(", ");
						 T.get(T.size() - 1).add_player(r[0], Integer.parseInt(r[1]));	
						 ok--;
					 }
				 }
				 
				 if(r[0].equals("handball")){
					 T.add(type_team.getTeam("handball"));
					 T.get(T.size() - 1).set_name(r[1]);
					 T.get(T.size() - 1).set_gender(r[2]);
					 T.get(T.size() - 1).set_nb(Integer.parseInt(r[3]));
					 int ok = Integer.parseInt(r[3]);
					 while(ok != 0) {
						 s = bufferedReader1.readLine();
						 r = s.split(", ");
						 T.get(T.size() - 1).add_player(r[0], Integer.parseInt(r[1]));	
						 ok--;
					 }
				 }
				 if(r[0].equals("basketball")){
					 T.add(type_team.getTeam("basketball"));
					 T.get(T.size() - 1).set_name(r[1]);
					 T.get(T.size() - 1).set_gender(r[2]);
					 T.get(T.size() - 1).set_nb(Integer.parseInt(r[3]));
					 int ok = Integer.parseInt(r[3]);
					 while(ok != 0) {
						 s = bufferedReader1.readLine();
						 r = s.split(", ");
						 T.get(T.size() - 1).add_player(r[0], Integer.parseInt(r[1]));	
						 ok--;
					 }
				 }
			 }

			if(args[0].equals("inscriere")) {
			 	for(i = 0; i < T.size(); i++) {
				 	T.get(i).list(args[3]);
				}
			 	output.close();
			}
			
			if(args[0].equals("competitie")) {
				FileReader fileReader2 = new FileReader(args[2]);
				BufferedReader bufferedReader2 = new BufferedReader(fileReader2);	
				while ((s = bufferedReader2.readLine()) != null) {
					r = s.split(", ");
					Competition C = new Competition(r[0], r[1]);
					if(r[0].equals("basketball")) {
						s = bufferedReader2.readLine();
						while (s != null &&  s != "football" && s != "basketball"  && s != "handball") {
							for(i = 0; i < T.size(); i++) {
								if(T.get(i).get_teamName().equals(s)) {
									if(T.get(i) instanceof BasketballTeam && T.get(i).get_gender().equals(r[1])) {
										C.teams.add(T.get(i));
										C.register((Team)T.get(i));
									}
									break;
								}
							}
							s = bufferedReader2.readLine();
						}
					}
					if(r[0].equals("handball")) {
						s = bufferedReader2.readLine();
						while (s != null &&  s != "football" && s != "basketball"  && s != "handball") {
							for(i = 0; i < T.size(); i++) {
								if(T.get(i).get_teamName().equals(s)) {
									if(T.get(i) instanceof HandballTeam && T.get(i).get_gender().equals(r[1])) {
										C.teams.add(T.get(i));
										C.register((Team)T.get(i));
									}
									break;
								}
							}
							s = bufferedReader2.readLine();
						}
					}
					if(r[0].equals("football")) {
						s = bufferedReader2.readLine();
						while (s != null &&  s != "football" && s != "basketball"  && s != "handball") {
							for(i = 0; i < T.size(); i++) {
								if(T.get(i).get_teamName().equals(s)) {
									if(T.get(i) instanceof FootballTeam && T.get(i).get_gender().equals(r[1])) {
										C.teams.add(T.get(i));
										C.register((Team)T.get(i));
									}
									break;
								}
							}
							s = bufferedReader2.readLine();
						}
					}
					C.start_competition();
					for(i = 0; i < 3; i++) {
						output.write(C.clasament.get(i).get_teamName());
						output.write("\r\n");	
					}
					for(i = 0; i < C.teams.size(); i++) {
						output.write("Echipa " + C.teams.get(i).get_teamName() + " a ocupat locul " + C.get_position(C.teams.get(i).get_teamName()));
						output.write("\r\n");	
					}
				}
				fileReader2.close();
				bufferedReader2.close();
			}
			output.close();
			fileReader1.close();
			bufferedReader1.close();				
		}
    	catch (ArrayIndexOutOfBoundsException e) {
        	e.printStackTrace();
		}	     
	
    	catch (Exception e){
        	e.printStackTrace();
		}
	}
}

