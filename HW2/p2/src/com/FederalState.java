/**
 * this class has exactly 16 instances representing the 16 federal states in Germany
 * reference: http://bethecoder.com/applications/tutorials/
 * design-patterns/java-design-patterns/nton.html
 * @author Dushan Terzikj 10001357, Dragi Kamov 30001478, Fanlin Wang 30000522, Sajit Kunwar 20331648
 * @since 17.03.2018
 */
package com;

import java.util.ArrayList;
import java.util.List;

public class FederalState {

    private static final String[] name = {
            "Baden Wurttemberg",
            "Bavaria",
            "Berlin",
            "Brandenburg",
            "Bremen",
            "Hamburg",
            "Hessen",
            "Mecklenburg-Vorpommern",
            "Niedersachsen",
            "North Rhine-Westphalia",
            "Rheinland-Pfalz",
            "Saarland",
            "Saxony",
            "Saxony-Anhalt",
            "Schleswig-Holstein",
            "Thuringia",
    };

    /**
     * Configure the number of instances required in the application.
     */
    private static final int NUM_OF_INSTANCES = 16;

    /**
     * store the 16 instances
     */
    private static final List<FederalState> instanceList = new ArrayList<FederalState>();
    private static int instanceRequestCount = 0;
    private String nameofState;

    /**
     * Make sure to have private default constructor.
     * This avoids direct instantiation of class using
     * new keyword/Class.newInstance() method
     */
    private FederalState() {}

    public static synchronized FederalState getInstance() {

        FederalState instance = null;

        if (instanceList.size() == NUM_OF_INSTANCES) {
            instance = instanceList.get(instanceRequestCount % NUM_OF_INSTANCES);
        } else {
            instance = new FederalState();
            instance.nameofState = name[instanceList.size()];
            instanceList.add(instance);
        }

        instanceRequestCount++;
        return instance;
    }

    /**
     * @return name of the state
     */
    public String getInstanceName() {
        return nameofState;
    }

    public String toString() {
        return "FederalState : " + getInstanceName();
    }

}
