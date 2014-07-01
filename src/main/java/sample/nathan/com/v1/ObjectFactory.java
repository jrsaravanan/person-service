//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.21 at 05:16:13 PM EDT 
//


package sample.nathan.com.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sample.nathan.com.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Addresses_QNAME = new QName("http://com.nathan.sample/v1.0", "addresses");
    private final static QName _DepartmentList_QNAME = new QName("http://com.nathan.sample/v1.0", "departmentList");
    private final static QName _PersonList_QNAME = new QName("http://com.nathan.sample/v1.0", "personList");
    private final static QName _Address_QNAME = new QName("http://com.nathan.sample/v1.0", "address");
    private final static QName _Department_QNAME = new QName("http://com.nathan.sample/v1.0", "department");
    private final static QName _Id_QNAME = new QName("http://com.nathan.sample/v1.0", "id");
    private final static QName _Person_QNAME = new QName("http://com.nathan.sample/v1.0", "person");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sample.nathan.com.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Id }
     * 
     */
    public Id createId() {
        return new Id();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link PersonList }
     * 
     */
    public PersonList createPersonList() {
        return new PersonList();
    }

    /**
     * Create an instance of {@link DepartmentList }
     * 
     */
    public DepartmentList createDepartmentList() {
        return new DepartmentList();
    }

    /**
     * Create an instance of {@link Department }
     * 
     */
    public Department createDepartment() {
        return new Department();
    }

    /**
     * Create an instance of {@link AddressList }
     * 
     */
    public AddressList createAddressList() {
        return new AddressList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "addresses")
    public JAXBElement<AddressList> createAddresses(AddressList value) {
        return new JAXBElement<AddressList>(_Addresses_QNAME, AddressList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartmentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "departmentList")
    public JAXBElement<DepartmentList> createDepartmentList(DepartmentList value) {
        return new JAXBElement<DepartmentList>(_DepartmentList_QNAME, DepartmentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "personList")
    public JAXBElement<PersonList> createPersonList(PersonList value) {
        return new JAXBElement<PersonList>(_PersonList_QNAME, PersonList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "address")
    public JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(_Address_QNAME, Address.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Department }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "department")
    public JAXBElement<Department> createDepartment(Department value) {
        return new JAXBElement<Department>(_Department_QNAME, Department.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Id }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "id")
    public JAXBElement<Id> createId(Id value) {
        return new JAXBElement<Id>(_Id_QNAME, Id.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.nathan.sample/v1.0", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

}
