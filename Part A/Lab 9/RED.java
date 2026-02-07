
import java.util.Random;
import java.util.Scanner;

public class RED {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of packets: ");
        int maxPackets = scanner.nextInt();

        System.out.print("Enter the queue size: ");
        int queueSize = scanner.nextInt();

        System.out.print("Enter minimum threshold (min_th): ");
        int minThreshold = scanner.nextInt();

        System.out.print("Enter maximum threshold (max_th): ");
        int maxThreshold = scanner.nextInt();

        simulateRED(maxPackets, queueSize, minThreshold, maxThreshold);
    }

    private static void simulateRED(int maxPackets, int queueSize,
            int minTh, int maxTh) {

        Random rand = new Random();
        int queueLength = 0;

        for (int i = 0; i < maxPackets; i++) {

            if (queueLength >= queueSize) {
                System.out.println("Packet dropped (QUEUE FULL)");
                continue;
            }

            double dropProbability = calculateDropProbability(
                    queueLength, minTh, maxTh
            );

            if (rand.nextDouble() < dropProbability) {
                System.out.print("Packet dropped (EARLY DROP)");
            } else {
                queueLength++;
                System.out.print("Packet accepted " + (i + 1));
            }
            System.out.println(" Queue length: " + queueLength + " | Drop probability: " + dropProbability);

        }
    }

    private static double calculateDropProbability(
            int q, int minTh, int maxTh) {

        if (q < minTh) {
            return 0.0;
        }

        if (q >= maxTh) {
            return 1.0;
        }

        return (double) (q - minTh) / (maxTh - minTh);
    }
}

// Enter the maximum number of packets: 50
// Enter the queue size: 60
// Enter minimum threshold (min_th): 30
// Enter maximum threshold (max_th): 45
// Packet accepted 1 Queue length: 1 | Drop probability: 0.0
// Packet accepted 2 Queue length: 2 | Drop probability: 0.0
// Packet accepted 3 Queue length: 3 | Drop probability: 0.0
// Packet accepted 4 Queue length: 4 | Drop probability: 0.0
// Packet accepted 5 Queue length: 5 | Drop probability: 0.0
// Packet accepted 6 Queue length: 6 | Drop probability: 0.0
// Packet accepted 7 Queue length: 7 | Drop probability: 0.0
// Packet accepted 8 Queue length: 8 | Drop probability: 0.0
// Packet accepted 9 Queue length: 9 | Drop probability: 0.0
// Packet accepted 10 Queue length: 10 | Drop probability: 0.0
// Packet accepted 11 Queue length: 11 | Drop probability: 0.0
// Packet accepted 12 Queue length: 12 | Drop probability: 0.0
// Packet accepted 13 Queue length: 13 | Drop probability: 0.0
// Packet accepted 14 Queue length: 14 | Drop probability: 0.0
// Packet accepted 15 Queue length: 15 | Drop probability: 0.0
// Packet accepted 16 Queue length: 16 | Drop probability: 0.0
// Packet accepted 17 Queue length: 17 | Drop probability: 0.0
// Packet accepted 18 Queue length: 18 | Drop probability: 0.0
// Packet accepted 19 Queue length: 19 | Drop probability: 0.0
// Packet accepted 20 Queue length: 20 | Drop probability: 0.0
// Packet accepted 21 Queue length: 21 | Drop probability: 0.0
// Packet accepted 22 Queue length: 22 | Drop probability: 0.0
// Packet accepted 23 Queue length: 23 | Drop probability: 0.0
// Packet accepted 24 Queue length: 24 | Drop probability: 0.0
// Packet accepted 25 Queue length: 25 | Drop probability: 0.0
// Packet accepted 26 Queue length: 26 | Drop probability: 0.0
// Packet accepted 27 Queue length: 27 | Drop probability: 0.0
// Packet accepted 28 Queue length: 28 | Drop probability: 0.0
// Packet accepted 29 Queue length: 29 | Drop probability: 0.0
// Packet accepted 30 Queue length: 30 | Drop probability: 0.0
// Packet accepted 31 Queue length: 31 | Drop probability: 0.0
// Packet accepted 32 Queue length: 32 | Drop probability: 0.06666666666666667
// Packet dropped (EARLY DROP) Queue length: 32 | Drop probability: 0.13333333333333333
// Packet accepted 34 Queue length: 33 | Drop probability: 0.13333333333333333
// Packet accepted 35 Queue length: 34 | Drop probability: 0.2
// Packet accepted 36 Queue length: 35 | Drop probability: 0.26666666666666666
// Packet dropped (EARLY DROP) Queue length: 35 | Drop probability: 0.3333333333333333
// Packet accepted 38 Queue length: 36 | Drop probability: 0.3333333333333333
// Packet accepted 39 Queue length: 37 | Drop probability: 0.4
// Packet accepted 40 Queue length: 38 | Drop probability: 0.4666666666666667
// Packet dropped (EARLY DROP) Queue length: 38 | Drop probability: 0.5333333333333333
// Packet accepted 42 Queue length: 39 | Drop probability: 0.5333333333333333
// Packet dropped (EARLY DROP) Queue length: 39 | Drop probability: 0.6
// Packet accepted 44 Queue length: 40 | Drop probability: 0.6
// Packet dropped (EARLY DROP) Queue length: 40 | Drop probability: 0.6666666666666666
// Packet accepted 46 Queue length: 41 | Drop probability: 0.6666666666666666
// Packet dropped (EARLY DROP) Queue length: 41 | Drop probability: 0.7333333333333333
// Packet dropped (EARLY DROP) Queue length: 41 | Drop probability: 0.7333333333333333
// Packet dropped (EARLY DROP) Queue length: 41 | Drop probability: 0.7333333333333333
// Packet dropped (EARLY DROP) Queue length: 41 | Drop probability: 0.7333333333333333
