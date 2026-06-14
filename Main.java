public class Main {

    public static void main(String[] args) {

        MetroGraph metro = new MetroGraph();

        // ================== STATIONS ==================

        metro.addStation("Rajiv Chowk");
        metro.addStation("New Delhi");
        metro.addStation("Mandi House");
        metro.addStation("Central Secretariat");
        metro.addStation("INA");
        metro.addStation("AIIMS");
        metro.addStation("Hauz Khas");
        metro.addStation("Kashmere Gate");
        metro.addStation("Chandni Chowk");
        metro.addStation("Civil Lines");
        metro.addStation("Saket");
        metro.addStation("Samaypur Badli");
        metro.addStation("Azadpur");
        metro.addStation("Dilshad Garden");
        metro.addStation("Rithala");
        metro.addStation("Pitampura");
        metro.addStation("Vishwavidyalya");
        metro.addStation("Netaji Subhash Place");
        metro.addStation("Rajouri Garden");
        metro.addStation("Janakpuri West");
        metro.addStation("Dwarka");
        metro.addStation("Delhi Aerocity");
        metro.addStation("Millenium City Centre Gurugram");
        metro.addStation("Qutub Minar");
        metro.addStation("Karol Bagh");
        metro.addStation("Khan Market");
        metro.addStation("Welcome");
        metro.addStation("Botanical Garden");
        metro.addStation("Dwarka Sec-21");
        metro.addStation("Noida Electronic City");

        // ================== STATION COLORS / LINES ==================

        // Yellow Line
        metro.setStationLine("Samaypur Badli", "Yellow");
        metro.setStationLine("Azadpur", "Yellow");
        metro.setStationLine("Vishwavidyalya", "Yellow");
        metro.setStationLine("Civil Lines", "Yellow");
        metro.setStationLine("Kashmere Gate", "Yellow");
        metro.setStationLine("Chandni Chowk", "Yellow");
        metro.setStationLine("New Delhi", "Yellow");
        metro.setStationLine("Rajiv Chowk", "Yellow");
        metro.setStationLine("Central Secretariat", "Yellow");
        metro.setStationLine("INA", "Yellow");
        metro.setStationLine("AIIMS", "Yellow");
        metro.setStationLine("Hauz Khas", "Yellow");
        metro.setStationLine("Saket", "Yellow");
        metro.setStationLine("Qutub Minar", "Yellow");
        metro.setStationLine("Millenium City Centre Gurugram", "Yellow");

        // Red Line
        metro.setStationLine("Rithala", "Red");
        metro.setStationLine("Pitampura", "Red");
        metro.setStationLine("Welcome", "Red");
        metro.setStationLine("Dilshad Garden", "Red");

        // Pink Line
        metro.setStationLine("Netaji Subhash Place", "Pink");
        metro.setStationLine("Rajouri Garden", "Pink");

        // Blue Line
        metro.setStationLine("Janakpuri West", "Blue");
        metro.setStationLine("Dwarka", "Blue");
        metro.setStationLine("Dwarka Sec-21", "Blue");
        metro.setStationLine("Botanical Garden", "Blue");
        metro.setStationLine("Noida Electronic City", "Blue");

        // Orange Line
        metro.setStationLine("Delhi Aerocity", "Orange");

        // Violet Line
        metro.setStationLine("Mandi House", "Violet");
        metro.setStationLine("Khan Market", "Violet");

        // ================== EDGES ==================

        // 🟡 Yellow Line
        metro.addEdge("Samaypur Badli", "Azadpur", 8);
        metro.addEdge("Azadpur", "Vishwavidyalya", 6);
        metro.addEdge("Vishwavidyalya", "Civil Lines", 3);
        metro.addEdge("Civil Lines", "Kashmere Gate", 2);
        metro.addEdge("Kashmere Gate", "Chandni Chowk", 2);
        metro.addEdge("Chandni Chowk", "New Delhi", 2);
        metro.addEdge("New Delhi", "Rajiv Chowk", 2);
        metro.addEdge("Rajiv Chowk", "Central Secretariat", 2);
        metro.addEdge("Central Secretariat", "INA", 2);
        metro.addEdge("INA", "AIIMS", 2);
        metro.addEdge("AIIMS", "Hauz Khas", 4);
        metro.addEdge("Hauz Khas", "Saket", 4);
        metro.addEdge("Saket", "Qutub Minar", 3);
        metro.addEdge("Qutub Minar", "Millenium City Centre Gurugram", 18);

        // 🔴 Red Line
        metro.addEdge("Rithala", "Pitampura", 4);
        metro.addEdge("Pitampura", "Netaji Subhash Place", 3);
        metro.addEdge("Netaji Subhash Place", "Kashmere Gate", 10);
        metro.addEdge("Kashmere Gate", "Welcome", 4);
        metro.addEdge("Welcome", "Dilshad Garden", 8);

        // 🩷 Pink Line
        metro.addEdge("Netaji Subhash Place", "Rajouri Garden", 10);

        // 🔵 Blue Line
        metro.addEdge("Rajouri Garden", "Janakpuri West", 10);
        metro.addEdge("Janakpuri West", "Dwarka", 10);
        metro.addEdge("Dwarka", "Dwarka Sec-21", 15);

        // 🟠 Airport Express
        metro.addEdge("New Delhi", "Delhi Aerocity", 20);
        metro.addEdge("Delhi Aerocity", "Dwarka Sec-21", 7);

        // 🔵 Blue Line (Noida Side)
        metro.addEdge("Botanical Garden", "Noida Electronic City", 16);

        // Interchange Connections
        metro.addEdge("Janakpuri West", "Hauz Khas", 20);
        metro.addEdge("Hauz Khas", "Botanical Garden", 18);

        // Tourist / Important Stations
        metro.addEdge("Rajiv Chowk", "Karol Bagh", 6);
        metro.addEdge("Rajiv Chowk", "Mandi House", 3);
        metro.addEdge("Mandi House", "Khan Market", 5);

        // ================== START GUI ==================

        new MetroGUI(metro);
    }
}