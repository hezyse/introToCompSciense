/**
 * The CityNode class represents a node in a linked list of cities.
 * Each node contains a city object and a reference to the next node.
 * The class provides methods to access and modify the city and next node.
 * 
 * @author Yehonatan Sela
 * @version 17.6.23
 */
public class CityNode {
    private City _city;
    private CityNode _next;

    /**
     * Constructs a new instance of the CityNode class with the given city.
     *
     * @param c the city object to be stored in the node
     */
    public CityNode(City c) {
        _city = new City(c);
        _next = null;
    }

    /**
     * Constructs a new instance of the CityNode class with the given city and next node.
     *
     * @param c     the city object to be stored in the node
     * @param next  the next node in the linked list
     */
    public CityNode(City c, CityNode next) {
        _city = new City(c);
        _next = next;
    }

    /**
     * Constructs a new instance of the CityNode class by copying another CityNode.
     *
     * @param c the CityNode object to be copied
     */
    public CityNode(CityNode c) {
        _next = null;
        City tmp = new City(c._city);
        this._city = tmp;
    }

    /**
     * Returns a copy of the city stored in the node.
     *
     * @return a copy of the city object
     */
    public City getCity() {
        City tmp = new City(this._city);
        return tmp;
    }

    /**
     * Returns the next node in the linked list.
     *
     * @return the next node
     */
    public CityNode getNext() {
        return this._next;
    }

    /**
     * Sets the city stored in the node.
     *
     * @param c the city object to be set
     */
    public void setCity(City c) {
        City tmp = new City(c);
        this._city = tmp;
    }

    /**
     * Sets the next node in the linked list.
     *
     * @param next the next node to be set
     */
    public void setNext(CityNode next) {
        this._next = next;
    }
}