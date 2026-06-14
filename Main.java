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

        
        // ================== EDGES ==================

        // 🟡 Yellow Line
metro.addEdge("Samaypur Badli", "Azadpur", 8, "Yellow");
metro.addEdge("Azadpur", "Vishwavidyalya", 6, "Yellow");
metro.addEdge("Vishwavidyalya", "Civil Lines", 3, "Yellow");
metro.addEdge("Civil Lines", "Kashmere Gate", 2, "Yellow");
metro.addEdge("Kashmere Gate", "Chandni Chowk", 2, "Yellow");
metro.addEdge("Chandni Chowk", "New Delhi", 2, "Yellow");
metro.addEdge("New Delhi", "Rajiv Chowk", 2, "Yellow");
metro.addEdge("Rajiv Chowk", "Central Secretariat", 2, "Yellow");
metro.addEdge("Central Secretariat", "INA", 2, "Yellow");
metro.addEdge("INA", "AIIMS", 2, "Yellow");
metro.addEdge("AIIMS", "Hauz Khas", 4, "Yellow");
metro.addEdge("Hauz Khas", "Saket", 4, "Yellow");
metro.addEdge("Saket", "Qutub Minar", 3, "Yellow");
metro.addEdge("Qutub Minar", "Millenium City Centre Gurugram", 18, "Yellow");

// 🔴 Red Line
metro.addEdge("Rithala", "Pitampura", 4, "Red");
metro.addEdge("Pitampura", "Netaji Subhash Place", 3, "Red");
metro.addEdge("Netaji Subhash Place", "Kashmere Gate", 10, "Red");
metro.addEdge("Kashmere Gate", "Welcome", 4, "Red");
metro.addEdge("Welcome", "Dilshad Garden", 8, "Red");

// 🩷 Pink Line
metro.addEdge("Netaji Subhash Place", "Rajouri Garden", 10, "Pink");

// 🔵 Blue Line
metro.addEdge("Rajouri Garden", "Janakpuri West", 10, "Blue");
metro.addEdge("Janakpuri West", "Dwarka", 10, "Blue");
metro.addEdge("Dwarka", "Dwarka Sec-21", 15, "Blue");

// 🟠 Airport Express
metro.addEdge("New Delhi", "Delhi Aerocity", 20, "Orange");
metro.addEdge("Delhi Aerocity", "Dwarka Sec-21", 7, "Orange");

// 🟣 Magenta Line
metro.addEdge("Janakpuri West", "Hauz Khas", 20, "Magenta");
metro.addEdge("Hauz Khas", "Botanical Garden", 18, "Magenta");

// 🔵 Blue Line (Noida Side)
metro.addEdge("Botanical Garden", "Noida Electronic City", 16, "Blue");

// 🟣 Violet Line
metro.addEdge("Rajiv Chowk", "Mandi House", 3, "Violet");
metro.addEdge("Mandi House", "Khan Market", 5, "Violet");

// Special Connection
metro.addEdge("Rajiv Chowk", "Karol Bagh", 6, "Blue");
        new MetroGUI(metro);
    }
}