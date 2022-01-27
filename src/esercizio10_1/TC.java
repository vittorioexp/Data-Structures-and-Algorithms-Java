// TC.java, memorizza tassi di cambio
public interface TC {
  public void   setChange( String valuta, double valore );
  public double euro( String valuta ) throws CurrencyNotFound;
}
