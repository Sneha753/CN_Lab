import java.util.*;

class Frame { // create a class Frame in which two attributes are declared i.e, seqNo and data
    int seqNo;
    String data;

    public Frame(int seqNo) { // Constructor Frame is used to refer seqNo in new Frames where seqNo is
                              // initialized
        this.seqNo = seqNo;
    }
}

public class framesort { // This is the main class Framesort
    public static void main(String[] args) { // The main method is begining with creating Scanner object
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total size of the message:"); // user input
        int total = sc.nextInt();
        System.out.print("Enter the size of each data:");
        int size = sc.nextInt();
        int n = total / size; // no of frames n

        List<Integer> seqList = new ArrayList<>(); // create list of seqNo's
        for (int i = 0; i < n; i++) {
            seqList.add(i);
        }

        Collections.shuffle(seqList); // shuffle seqNo's in list

        List<Frame> frames = new ArrayList<>(); // create list of frames
        for (int i = 0; i < n; i++) {
            int seqNo = seqList.remove(0);
            frames.add(new Frame(seqNo));
        }

        for (Frame frame : frames) {
            System.out.print("Enter frame data for seqNo with size :" + size + ":" + frame.seqNo + ":"); // user input -
                                                                                                         // data of each
            String data = sc.next();
            frame.data = data;
        }

        frames.sort((frame1, frame2) -> Integer.compare(frame1.seqNo, frame2.seqNo)); // sorting frames based on seqNo
        System.out.println("\n---Sorted Frames--\n");
        for (Frame frame : frames) {
             System.out.println(frame.seqNo + "-" + frame.data); // printing after sorting frames

        }

    }

}
