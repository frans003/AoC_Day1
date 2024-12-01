import java.util.*;

public class Parser {
    public void parseInput(String input) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        Scanner scanner = new Scanner(input);

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s{3}");
                if (parts.length == 2) {
                    leftList.add(Integer.parseInt(parts[0]));
                    rightList.add(Integer.parseInt(parts[1]));
                }
            }

            //Sorting the list
            leftList.sort(Comparator.reverseOrder());
            Collections.sort(leftList);
            Collections.sort(rightList);

            Integer sumOfAllId = 0;

            while(!leftList.isEmpty()){
                if (leftList.get(0) > rightList.get(0)) {
                    sumOfAllId += (leftList.get(0) - rightList.get(0));
                } else {
                    sumOfAllId += (rightList.get(0) - leftList.get(0));
                }
                leftList.removeFirst();
                rightList.removeFirst();
            }

            //Printing the list
            System.out.println(leftList);
            System.out.println(rightList);
            System.out.println(sumOfAllId);
        } catch (Exception e){
            System.out.println(e);
        };
    }

    public void similarityScore(String input) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        Scanner scanner = new Scanner(input);

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\s{3}");
                if (parts.length == 2) {
                    leftList.add(Integer.parseInt(parts[0]));
                    rightList.add(Integer.parseInt(parts[1]));
                }
            }

            //Sorting the list

            Integer similarity = 0;
            Integer position = 0;

            System.out.println(leftList.size());

            while(position != leftList.size()){
                int count = Collections.frequency(rightList, leftList.get(position));

                similarity += (leftList.get(position) * count);

                position += 1;
            }

            //Printing the list
            System.out.println(similarity);

        } catch (Exception e){
            System.out.println(e);
        };
    }
}