
class ThrottlingGateway {

    public static void main(String[] args) {
        int[] requestTimes = new int[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11 };
        System.out.println(droppedRequests(requestTimes));
    }

    public static int droppedRequests(int[] requestTimes) {
        int[] requests = new int[requestTimes[requestTimes.length - 1] + 1];
        for (int i = 0; i < requestTimes.length; i++) {
            requests[requestTimes[i]]++;
        }
        int tenSecondBucket = 20;
        int sixtySecondBucket = 60;

        int dropped = 0;

        for (int i = 0; i < requests.length; i++) {
            int numberOfRequests = requests[i];

            // count number of requests that will be dropped by one second rule
            int droppedByOneSecondRule = Math.max(numberOfRequests - 3, 0);

            // count number of requests that will be dropped by 10 second rule
            int droppedByTenSecondRule = 0;
            if (tenSecondBucket > 0) {
                droppedByTenSecondRule = Math.max(numberOfRequests - tenSecondBucket, 0);
            } else {
                droppedByTenSecondRule = numberOfRequests;
            }

            // count number of requests that will be dropped by sixty second rule
            int droppedBySixtySecondRule = 0;
            if (sixtySecondBucket > 0) {
                droppedBySixtySecondRule = Math.max(numberOfRequests - sixtySecondBucket, 0);
            } else {
                droppedBySixtySecondRule = numberOfRequests;
            }

            // one request dropped is only counted once against even if multiple buckets
            // would have dropped it. So take the max number of requests dropped
            dropped += Math.max(droppedByOneSecondRule, Math.max(droppedByTenSecondRule, droppedBySixtySecondRule));

            // reduce 1 token from each bucket for every request.
            // As per "note" in question, dropped requests are counted toward future
            // calculations
            // so allow buckets to go negative
            tenSecondBucket -= numberOfRequests;
            sixtySecondBucket -= numberOfRequests;

            // we allow token buckets to go negative because we need to count even dropped
            // requests for future calculations.
            // This means we need replace the lost tokens when those requests exit the time
            // period. For example if 10 requests were made on time '1' then on time 11
            // we need to put back those 10 tokens.
            // If no requests were made then we need to add 2 tokens for the 10 second
            // bucket
            // If one request was made then we need to add 1 more token.
            // Note: we use index 10 here because the token replinishment is done for next
            // iteration
            // i.e. for 11th onwards iteration
            if (i > 9) {
                int expiredTokens = requests[i - 9];
                tenSecondBucket += expiredTokens;
                if (expiredTokens < 2) {
                    tenSecondBucket += (2 - expiredTokens);
                }
            }
            if (i > 59) {
                int expiredTokens = requests[i - 59];
                sixtySecondBucket += expiredTokens;
                if (expiredTokens == 0) {
                    sixtySecondBucket++;
                }
            }
        }

        return dropped;
    }

}