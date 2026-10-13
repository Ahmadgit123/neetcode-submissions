class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length())
                   .append("#")
                   .append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String encoded_string) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < encoded_string.length()) {
            int j = i;

            // Find the '#' separator
            while (encoded_string.charAt(j) != '#') {
                j++;
            }

            // Get the length of the original string
            int length = Integer.parseInt(
                encoded_string.substring(i, j)
            );

            // Extract the original string
            int start = j + 1;
            int end = start + length;

            result.add(encoded_string.substring(start, end));

            // Move to the next encoded string
            i = end;
        }

        return result;
    }
}
