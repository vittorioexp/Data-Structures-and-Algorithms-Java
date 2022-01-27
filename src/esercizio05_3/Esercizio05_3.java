public class Esercizio05_3 { 
public static void main(String[] args) { 

	Stringa s = new Stringa("Un esercizio davvero facilissimo!");
 Stringa sa = new Stringa("UUnn ");
 Stringa sb = sa.substring(sa.indexOf(new Stringa("U")), sa.lastIndexOf(new Stringa("U")));
 Stringa s2 = new Stringa("");
 s2 = s2.concat(sb);
 s2 = s2.concat(sa.substring(2, 3));
 s2 = s2.concat(sa.substring(sa.length()-1));
 sb = new Stringa("esercizio ");
 if (sa.endsWith(new Stringa(" ")))
 s2 = s2.concat(sb);
 else
 s2 = s2.concat(sa);
 s2 = s2.concat(s.substring(s.indexOf(new Stringa("d"))));
 if (s.compareTo(s2) == 0)
 System.out.println("Collaudo effettuato con successo");
 else
 System.out.println("Collaudo fallito");
 }
}