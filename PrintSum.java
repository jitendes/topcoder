public static void find(int num) { 
if (num == 0) { 
printLine(); 
return; 
} 
for (int i = 1; i <= num; i++) { 
if (line.isEmpty() || line.getLast() <= i) { 
line.add(i); 
find(num - i); 
line.removeLast(); 
} 
} 
} 
 
public static void printLine() { 
if (line.size() == 0) 
return; 
StringBuilder result = new StringBuilder(); 
for (int i = 0; i < line.size() - 1; i++) { 
result.append(line.get(i) + " + "); 
} 
result.append(line.get(line.size() - 1)); 
System.out.println(result.toString()); 
} 
 
