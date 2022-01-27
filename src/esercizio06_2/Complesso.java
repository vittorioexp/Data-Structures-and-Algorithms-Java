/*
    L'insieme C dei numeri complessi e' l'insieme delle coppie ordinate (x,y) 
    con x e y appartenenti a R (insieme dei numeri reali).
    Dato il numero complesso z = x + i *y,  i numeri reali x e y sono detti
    parte reale e parte immaginaria di z.
    Nei commenti che seguono, facciamo riferimento ai numeri complessi
        z = x + i*y, z1 = x1 + i*y1, z2 = x2 + i*y2
*/


// Attenzione: 
// 1) Ovviamente il file va rinominato in Complesso.java
// 2) notate che, sebbene i corpi dei metodi non siano ancora  
//    stati scritti, questo codice compila correttamente perche` 
//    abbiamo inserito degli enunciati di return. 


public class Complesso {
	private double re;
	private double im;
    // inizializza il numero complesso al valore 0 + i0 (zero complesso)
    public Complesso() { 
		re=0;
		im=0;
    }

    // inizializza il numero complesso al valore re + i*im
    public Complesso(double realPart, double imagPart) { //completare
		re = realPart;
		im = imagPart;
    }

    //Somma a questo numero complesso il numero complesso z
    //somma di due complessi: z = z1+z2 = (x1+x2) + i(y1+y2)
    public Complesso add(Complesso z)
    {  
		double x = this.re + z.getRe();
		double y = this.im + z.getIm();
		return new Complesso(x,y);
    }

    //Sottrae a questo numero complesso il numero complesso z
    //sottrazione di due complessi: z = z1-z2 = (x1-x2) +i(y1-y2)
    public Complesso sub(Complesso z) {
		double x = this.re-z.getRe();
		double y = this.im-z.getIm();
		return new Complesso(x,y);
    }

    //Moltiplica questo numero complesso per il numero complesso z
    //prodotto di due complessi: z = z1*z2 = (x1*x2 -y1*y2) + i*(x1*y2 + x2*y1)
    public Complesso mult(Complesso z) {
		double x = (this.re*z.getRe())-(this.im*z.getIm());
		double y = (this.re*z.getIm())+(z.getRe()*this.im);
		return new Complesso(x,y);
    }

    //Divide questo numero complesso per il numero complesso z
    //divisione fra due complessi: z1/z2 = z1 *1/z2, per z2 != 0
    public Complesso div(Complesso z) {
		double x=0;
		double y=0;
		if (z.getRe()!=0 && z.getIm()!=0) {
			x = (this.re*z.getRe() + this.im*z.getIm())/(z.getRe()*z.getRe() + z.getIm()*z.getIm());
			y = (this.im*z.getRe() - this.re*z.getIm())/(z.getRe()*z.getRe() + z.getIm()*z.getIm());
		}
		return new Complesso(x,y);
    }
          
    //Calcola il coniugato di questo numero complesso
    //coniugato del complesso z:  z^= x - i*y
    public Complesso conj() {
		double x = this.re;
		double y = 0 - this.im;
		return new Complesso(x,y);
    }
          
    //Calcola l'inverso rispetto al prodotto di un numero complesso
    //inverso del complesso z: 1/z = x/(|z|*|z|) -i*y/(|z|*|z|), per z != 0
    public Complesso inv()
    {
		double x=0;
		double y=0;
		if (this.re!=0 && this.im!=0) {
			x = (this.re)/(this.re*this.re + this.im*this.im);
			y = (this.im)/(this.re*this.re + this.im*this.im);
		}
		return new Complesso(x,y);
    }

    //Calcola il modulo di questo numero complesso
    //modulo del complesso z: |z| = sqrt( x*x + y*y).
    public double mod() {
		return Math.sqrt(this.re*this.re + this.im*this.im);
    }
           
    //Confronta con tolleranza due numeri complessi.
    public boolean approxEquals(Complesso z) {
		return (this.re==z.getRe() && this.im==z.getIm());
    }

    //Crea una stringa che rappresenta questo numero complesso
    //Formato stringa: parte reale + i*parte immaginaria
    public String toString() {
		return this.re+" +i*"+this.im;
    }


    //-------- metodi di accesso ----------
          
    //Restituisce la parte complessa di un numero complesso
    public double getIm() {
		return this.im;  //completare
    }
    //Restituisce la parte reale di un numero complesso
    public double getRe() {
		return this.re;  //completare
    }
}