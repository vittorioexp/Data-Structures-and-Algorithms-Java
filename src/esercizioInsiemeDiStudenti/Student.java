public class Student
{
private String matricola; //identificatore univoco
private String cognome;
private String nome;

public Student (String m, String c, String n) { 
	matricola=m;
	cognome=c;
	nome=n;
}

public String getMatricola() { 
	return matricola;
}

public String getCognome() { 
	return cognome;
}

public String getNome() { 
	return nome;
}

public int compareTo(Student s) {
	if (cognome.compareTo(s.getCognome())!=0) return cognome.compareTo(s.getCognome());
	if (nome.compareTo(s.getNome())!=0) return nome.compareTo(s.getNome());
	return matricola.compareTo(s.getMatricola());
}
public boolean equals(Student s) {
	return compareTo(s)==0;
}

}