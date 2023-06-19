
/**
 * Write a description of class StudentsTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentsTester
{
    public static void main(String[] args)
    {
        System.out.println("============ Starting students tester for MAMAN 14 ============\n");
        City c1 = new City("Jerusalem", 1, 2, 3, 4, 5, 6, 7, 8, 9);
        CityNode cn1 = new CityNode(c1);
        City c2 = new City("Tel-Aviv", 11, 12, 13, 14, 15, 16, 17, 18, 19);
        CityNode cn2 = new CityNode(c1, cn1);
        CityNode cn3 = new CityNode(cn2);

        City c3 = cn1.getCity();
        CityNode cn4 = cn2.getNext();
        cn4.setCity(c3);
        cn2.setNext(cn1);

        Country co1 = new Country("Utopia");
        co1.addCity("Jerusalem", 1, 2, 3, 4, 5, 6, 7, 8, 9);
        co1.addCity("Tel-Aviv", 11, 12, 13, 14, 15, 16, 17, 18, 19);

        Country co2 = new Country("Israel");
        co2.addCity("Holon", 11, 1, 2023, 4, 5, 6, 7, 8, 9);
        co2.addCity("Bat-Yam", 11, 3, 2003, 14, 15, 16, 17, 18, 19);
        co2.addCity("Haifa", 11, 4, 2003, 14, 120, 16, 17, 180, 49);

        System.out.println(co2);
        boolean b2 = co2.wereCitiesEstablishedBeforeOrAfter(new Date(10, 5, 2023), new Date(5, 5, 2005));
        double d2 = co2.longestDistance();
        long i2 = co2.getNumOfResidents();

        c2 = co2.unifyCities("Haifa", "Bat-Yam");
        System.out.println("The unified cities\n"+co2);



        long i1 = co1.getNumOfResidents();
        double d1 = co1.longestDistance();
        i1 = co1.numCitiesNorthOf("Jerusalem");
        c1 = co1.southernmostCity();
        String s1 = co1.getCountryName();
        i1 = co1.getNumOfCities();
        boolean b1 = co1.wereCitiesEstablishedBeforeOrAfter(new Date(10, 10, 2010), new Date(5, 5, 2005));
        c1 = co1.unifyCities("Jerusalem", "Tel-Aviv");
        i1 = co1.establishMaxDiff();
        System.out.println("Current country value :\n" + co1);
        System.out.println("============ Finishing students tester for MAMAN 14 ============");

        System.out.println(
                "The tester compiled and ran without any error.\n" +
                        "PLEASE NOTICE : ALL THIS TESTER CHECKS is whether you\n" +
                        "wrote all the expected constructors and methods in the\n" +
                        "CityNode and Country classes, and that you used the correct\n" +
                        "interface (i.e. number of parameters and types.)\n" +
                        "THIS TESTER DOES NOT CHECK WHETHER YOUR CODE DOES THE JOB WELL.\n" +
                        "YOU SHOULD WRITE YOUR OWN TESTER TO CHECK FOR THE CORRECTNESS OF YOUR CODE.\n" +
                        "However if your code does not compile with this tester, your grade for\n" +
                        "this MAMAN will be 0, without any possibility of appeal !\n");
    }
}
