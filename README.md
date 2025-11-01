# ☕ Coffee Maker App

Ez a projekt egy **kávékészítő alkalmazás**, amely demonstrálja három klasszikus **programtervezési minta** (Design Pattern) használatát:
- **Factory Method**
- **Decorator**
- **Command**

A programhoz tartozik egy egyszerű, stílusos **Swing alapú grafikus felület (GUI)** is, amelyen keresztül a felhasználó különböző kávékat készíthet, extrákat adhat hozzá, és vezérelheti a kávégép működését.

---

## 🎯 Projekt célja

A cél a programtervezési minták gyakorlati alkalmazásának bemutatása egy valószerű, de egyszerű példán keresztül — a kávékészítés folyamatán.  
A felhasználó különböző kávéfajták közül választhat (Espresso, Latte, Cappuccino), majd eldöntheti, szeretne-e hozzá **tejet** és/vagy **cukrot**.  
A program a választások alapján dinamikusan hozza létre és díszíti a kávét az adott minták segítségével.

---

## 🧩 Alkalmazott minták

### ☕ Factory Method
**Cél:** az objektumok létrehozásának elkülönítése a konkrét implementációtól.  
**Alkalmazás:**  
A `MakeCoffee` osztály gyárként működik, amely a felhasználó által kiválasztott típus alapján (Espresso, Latte, Cappuccino) hozza létre a megfelelő `Coffee` objektumot.  
Ez biztosítja, hogy az új kávétípusok könnyen hozzáadhatók a kód módosítása nélkül.

### 🍶 Decorator
**Cél:** objektumok viselkedésének bővítése öröklődés nélkül.  
**Alkalmazás:**  
A `WithMilk` és `WithWhiteSugar` osztályok dekorátorként működnek.  
A kiválasztott `Coffee` objektumot futásidőben „feldíszítik” extra tulajdonságokkal (tej, cukor).  
Így a `Coffee` objektum funkcionalitása dinamikusan bővül.

### ⚙️ Command
**Cél:** a műveletek elkülönítése a meghívó objektumtól.  
**Alkalmazás:**  
A `StartCommand`, `StopCommand` és `CleanCommand` osztályok a kávégép műveleteit reprezentálják.  
Az `Invoker` (pl. gombnyomás a GUI-ban) ezek segítségével indítja vagy állítja le a kávéfőzést, illetve tisztítja a gépet.

---

## 🖥️ GUI funkciók

A `CoffeeGUI.java` egy egyszerű, **Swing alapú grafikus felület**, amely barna és krém színvilágával kávézós hangulatot teremt.  
A felület elemei:

- ☕ **Kávé kiválasztása:** `JComboBox` (Espresso / Latte / Cappuccino)
- 🥛 **Extra hozzávalók:** `JCheckBox` (Tej, Cukor)
- ▶️ **Vezérlés:** Start, Stop, Clean gombok
- 💬 **Státusz kijelző:** `JTextArea`, ahol megjelennek az üzenetek és az elkészült kávék információi

A GUI a háttérben a **Command** mintán keresztül kommunikál a kávéfőző logikával, és a **Decorator** segítségével módosítja a létrehozott kávékat.

---

## 🧱 Projekt struktúra

src/
├── command/
│ ├── Command.java
│ ├── StartCommand.java
│ ├── StopCommand.java
│ ├── CleanCommand.java
│ ├── CoffeeInvoker.java
│ └── CoffeeMachine.java
│
├── decorator/
│ ├── PlusElements.java
│ ├── WithMilk.java
│ ├── WithWhiteSugar.java
│
├── factory/
│ ├── MakeCoffee.java
│ ├── Espresso.java
│ ├── Latte.java
│ ├── Cappuccino.java
│ ├── Coffee.java
│
└── ui/
└── CoffeeMakerPanel.java

## 🚀 Futtatás

1. Klónozd vagy töltsd le a projektet.  
2. Nyisd meg pl. **IntelliJ IDEA**, **NetBeans** vagy **Eclipse** alatt.  
3. Futtasd a `CoffeeGUI.java` fájlt.  
4. Élvezd a digitális kávékészítést! ☕

---

## 💡 Lehetséges továbbfejlesztések

- **Adatbázis kapcsolat:** a korábbi rendeléseket vagy kávépreferenciákat elmenthetnénk.  
- **Observer minta:** kijelzők vagy értesítések kezelése, ha a kávé elkészült.  
- **Strategy minta:** különböző elkészítési módok (pl. erős, gyenge, dupla adag).  
- **Template Method:** általános kávéfőzési sablon definiálása különböző lépésekkel.

---

### ☕ Készítette:
**László Andrea**  
*Programtervezési minták — beadandó projekt (Factory, Decorator, Command)*  
2025
