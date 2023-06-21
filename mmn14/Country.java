/**
* Class Country shows country and its cities.
* @author Yehonatan Sela
* @version 17.6.23
*/

public class Country
{
    CityNode _head;
    private String _name;

    /**
     * Constructs a new instance of the Country class with the given name.
     *
     * @param name the name of the country
     */
    public Country(String name)
    {
        _name=name;
        _head=null;
    }

    /**
     * Adds a city to the country.
     *
     * @param cityName          the name of the city
     * @param dayEstablished    the day of establishment
     * @param monthEstablished  the month of establishment
     * @param yearEstablished   the year of establishment
     * @param centerX           the x-coordinate of the city center
     * @param centerY           the y-coordinate of the city center
     * @param stationX          the x-coordinate of the central station
     * @param stationY          the y-coordinate of the central station
     * @param numOfResidents    the number of residents in the city
     * @param noOfNeighborhoods the number of neighborhoods in the city
     * @return true if the city was added successfully, false if dont
     */
    public boolean addCity(String cityName, int dayEstablished, int monthEstablished,
                           int yearEstablished, int centerX, int centerY, int stationX, int stationY, long numOfResidents, int noOfNeighborhoods)
    {
        City c=new City(cityName,dayEstablished,monthEstablished,
                yearEstablished,centerX,centerY,stationX,stationY,numOfResidents,noOfNeighborhoods);
        //check if city exists
        if(!isExist(cityName))
        {
            CityNode cityN=new CityNode(c);
            //first city head is null
            if(_head==null)
                _head=cityN;
            else
            {
                CityNode tmp = _head;
                while(tmp!=null)
                {
                    // if new city is older than current city will add it before
                    if(isOlder(c, tmp.getCity()))
                    {
                        //updating pointing
                        cityN.setNext(tmp);
                        if(tmp == _head) // changing the head of the cities
                            _head = cityN;
                        else {
                            CityNode prevNode = getPrevious(tmp);
                            cityN.setNext(prevNode.getNext());
                            prevNode.setNext(cityN);
                        }
                        break;
                    }
                    else
                    {
                        //if they established on same date we will check lexicographic
                        if(tmp.getCity().getDateEstablished().equals(c.getDateEstablished()))
                        {
                            if(cityName.compareTo(tmp.getCity().getCityName())<0)
                            {
                                //new city will insert before
                                cityN.setNext(tmp);
                                CityNode prevNode = getPrevious(tmp);
                                //if the new city becomes the first city we update the head
                                if(prevNode == _head)
                                    _head = cityN;
                                else
                                    prevNode.setNext(cityN);
                            }
                            else
                            {
                                cityN.setNext(tmp.getNext());
                                tmp.setNext(cityN);
                            }
                            break;
                        }
                    }
                    //reached last city
                    if(tmp.getNext() == null)
                    {
                        tmp.setNext(cityN);
                        break;
                    }
                    tmp=tmp.getNext();
                }
            }
            return true;

        }
        return false;
    }

    /**
     * Checks if a city with the given name already exists in the country.
     *
     * @param name the name of the city to check
     * @return true if the city exists, false if dont
     */
    public boolean isExist(String name)
    {
        if(_head==null)
            return false;
        CityNode tmp = _head;
        while(tmp!=null)
        {
            if(name.equals(tmp.getCity().getCityName()))
            {
                return true;
            }
            tmp=tmp.getNext();
        }
        return false;
    }

    /**
     * Checks if a city is older than another city based on their establishment dates.
     *
     * @param exist the existing city to compare
     * @param newC  the new city to compare
     * @return true if the new city is older, false otherwise
     */
    public boolean isOlder(City exist,City newC)
    {
        return exist.getDateEstablished().before(newC.getDateEstablished());

    }

    /**
     * Retrieves the previous CityNode given a CityNode.
     *
     * @param node the CityNode to find the previous node for
     * @return the previous CityNode, or null if not found
     */
    public CityNode getPrevious(CityNode node)
    {
        if(_head==null)
            return null;
        CityNode tmp=_head;
        while(tmp!=null)
        {
            //only 1 element so we return the head
            if(_head == node)
            {
                return _head;
            }
            if(tmp.getNext()==node)
            {
                return tmp;
            }
            tmp=tmp.getNext();
        }
        return null;
    }

    /**
     * Calculates the total number of residents in all cities of the country.
     *
     * @return the total number of residents
     */
    public long getNumOfResidents()
    {
        CityNode tmp=_head;
        long sum=0;
        while(tmp!=null)
        {
            sum+=tmp.getCity().getNumOfResidents();
            tmp=tmp.getNext();
        }
        return sum;
    }

     /**
     * Finds the longest distance between any two cities in the country.
     *
     * @return the longest distance between two cities
     */
    public double longestDistance()
    {
        if(_head.getNext()==null || _head == null)
            return 0;
        double maxDistance=0;
        for(CityNode tmp =_head;tmp!=null;tmp=tmp.getNext())
        {
            for(CityNode tmp2 =tmp.getNext();tmp2!=null;tmp2=tmp2.getNext())
            {
                double distance=getDistance(tmp.getCity().getCityCenter(),tmp2.getCity().getCityCenter());
                maxDistance= Math.max(distance, maxDistance);
            }
        }
        return maxDistance;
    }

    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param x the first point
     * @param y the second point
     * @return the distance between the two points
     */
    public double getDistance(Point x, Point y)
    {
        double xDistance=Math.pow(x.getX()-y.getX(),2);
        double yDistance=Math.pow(x.getY()-y.getY(),2);
        return(Math.sqrt(xDistance+yDistance));
    }

    /**
     * Counts the number of cities located north of a given city.
     *
     * @param cityName the name of the city to compare
     * @return the number of cities located north of the given city, or -1 if the city doesn't exist
     */
    public int numCitiesNorthOf(String cityName)
    {
        if(!isExist(cityName))
            return -1;
        CityNode tmp=_head;
        int cityY=0;
        while(tmp!=null)
        {
            // if a city is northen its y will be bigger so we will check if Y is bigger the Y of city
            if(tmp.getCity().getCityName()==cityName)
            {
                cityY=tmp.getCity().getCityCenter().getY();
                break;
            }
            tmp=tmp.getNext();
        }
        int counter=0;
        tmp=_head;
        while(tmp!=null)
        {
            if(tmp.getCity().getCityCenter().getY()>cityY)
                counter++;
            tmp=tmp.getNext();
        }
        return counter;
    }

    /**
     * Finds the southernmost city in the country.
     *
     * @return the southernmost city, or null if no cities exist
     */
    public City southernmostCity()
    {
        if(_head.getNext()==null || _head==null)
            return null;
        CityNode tmp =_head;
        City southest=tmp.getCity();
        while(tmp!=null)
        {
            // similar to northen if Y is smaller then its southern but here we return a city
            if(tmp.getCity().getCityCenter().getY()<southest.getCityCenter().getY())
                southest=tmp.getCity();
            if(tmp.getCity().getCityCenter().getY()==southest.getCityCenter().getY())
            {
                if(isOlder(southest,tmp.getCity()))
                    southest=tmp.getCity();
            }
            tmp=tmp.getNext();
        }
        City southestReturn=new City(southest);
        return southestReturn;
    }

    /**
     * Retrieves the name of the country.
     *
     * @return the name of the country
     */
    public String getCountryName()
    {
        return _name;
    }

    /**
     * Retrieves the number of cities in the country.
     *
     * @return the number of cities
     */
    public int getNumOfCities()
    {
        CityNode tmp=_head;
        int counter=0;
        while(tmp!=null)
        {
            counter++;
            tmp=tmp.getNext();
        }
        return counter;
    }

    /**
     * Checks if any cities in the country were established before or after a given date range.
     *
     * @param d1 the first date of the range
     * @param d2 the second date of the range
     * @return true if there are cities established before or after the date range, false otherwise
     */
    public boolean wereCitiesEstablishedBeforeOrAfter(Date d1, Date d2)
    {
        CityNode tmp=_head;
        Date young;
        Date old;
        // check which date is younger than the other
        if(isYounger(d1,d2))
        {
            young=d1;
            old=d2;
        }
        else
        {
            young=d2;
            old=d1;
        }
        while(tmp!=null)
        {
            // check if a city was established before the min time or after the max
            if(isYounger(tmp.getCity().getDateEstablished(),young)||(isYounger(old,tmp.getCity().getDateEstablished())))
                return true;
            else
                tmp=tmp.getNext();
        }
        return false;
    }

    /**
     * Checks if a given date is younger than another date.
     *
     * @param young the younger date
     * @param old   the older date
     * @return true if the young date is younger, false otherwise
     */
    public boolean isYounger(Date young, Date old)
    {
        return young.after(old);

    }

    /**
     * Unifies two cities in the country into a single city.
     *
     * @param nameCity1 the name of the first city
     * @param nameCity2 the name of the second city
     * @return the unified city, or null if either city doesn't exist
     */
    public City unifyCities(String nameCity1,String nameCity2)
    {
        CityNode tmp=_head;
        City city1=tmp.getCity();
        City city2=tmp.getCity();
        CityNode c2Node=tmp;
        CityNode c1Node=tmp;
        while(tmp!=null)
        {
            // setting the nodes for c1Node and c2Node
            if(tmp.getCity().getCityName().equals(nameCity1))
            {
                city1=tmp.getCity();
                c1Node=tmp;
            }
            if(tmp.getCity().getCityName().equals(nameCity2))
            {
                city2=tmp.getCity();
                c2Node=tmp;
            }
            tmp=tmp.getNext();
        }
        //checking which city to merge to
        if(isOlder(city1,city2))
        {
            performUnify(city1, city2, c1Node, c2Node);
            return city1;
        }
        else
        {
            performUnify(city2, city1, c2Node, c1Node);
            return city2;
        }
    }

    /**
     * Performs the actual unification of two cities.
     * we return void because we do operations on aliasing 
     *
     * @param city1   the city to be unified
     * @param city2   the city we unify to city 1
     * @param c1Node  the node containing the first city
     * @param c2Node  the node containing the second city
     */
    private void performUnify (City city1, City city2, CityNode c1Node, CityNode c2Node)
    {
        city1.setCityName(city1.getCityName()+"-"+city2.getCityName());
        city1.setDateEstablished(city1.getDateEstablished());
        city1.setNumOfResidents(city1.getNumOfResidents()+city2.getNumOfResidents());
        city1.setNumOfNeighborhoods(city1.getNumOfNeighborhoods()+city2.getNumOfNeighborhoods());
        if(city1.getCentralStation().getX()>city2.getCentralStation().getX())
            city1.setCentralStation(city1.getCentralStation());
        else
            city1.setCentralStation(city2.getCentralStation());
        city1.setCityCenter(getMiddle(city1.getCityCenter(),city2.getCityCenter()));
        c1Node.setCity(city1);
        CityNode tmpC2=getPrevious(c2Node);
        //removing the city merged to
        tmpC2.setNext(c2Node.getNext());
        c2Node.setNext(null);
    }

    /**
     * Calculates the middle point between two points.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @return the middle point between the two points
     */
    public Point getMiddle(Point p1, Point p2)
    {
        int xMiddle=((p1.getX()+p2.getX())/2);
        int yMiddle=((p1.getY()+p2.getY())/2);
        Point middle=new Point(xMiddle,yMiddle);
        return (middle);
    }

    /**
     * Calculates the maximum difference in establishment dates between the first and last city in the country.
     *
     * @return the maximum difference in days, or -1 if no cities exist
     */
    public int establishMaxDiff()
    {
        if(_head == null)
            return -1;
        if(_head.getNext() == null)
            return 0;
        CityNode tmp=_head;
        while(tmp!=null)
        {
            tmp=tmp.getNext();
        }
        // The list is already sorted so we calculate the difference between the head and the last node.
        return(_head.getCity().getDateEstablished().difference(tmp.getCity().getDateEstablished()));
    }

    /**
     * Returns a string representation of the country and its cities.
     *
     * @return a string representation of the country
     */
    public String toString()
    {
        String str="Cities of: " +this._name+"\n";
        CityNode tmp=_head;
        while(tmp!=null)
        {
            str += "\nCity name: " + tmp.getCity().getCityName()+"\n Date established: "+tmp.getCity().getDateEstablished()+
                    "\n City center: " + tmp.getCity().getCityCenter() + "\n Central Station: " + tmp.getCity().getCentralStation()+
                    "\n Number of residents: " + tmp.getCity().getNumOfResidents() + "\n Number of neighborhoods: " + tmp.getCity().getNumOfNeighborhoods() + " \n";
            tmp=tmp.getNext();
        }
        return str;
    }
}
