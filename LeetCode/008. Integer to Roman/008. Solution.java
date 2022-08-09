/**
 * https://leetcode.com/problems/integer-to-roman/
 */
class Solution {
    public String intToRoman(int num) {
        int i = 1;

        String labels[] = new String[3];
        int unit;
        StringBuilder sb = new StringBuilder();
        while(true){
            unit = num % 10;
            num = num/10;
            defineLabels(labels, i);
            sb = buildValue(unit, labels).append(sb);

            if(num <= 0) break;
            i++;
        }
        return sb.toString();
    }

private StringBuilder buildValue(int number, String labels[]){
        final StringBuilder sb = new StringBuilder();
        switch(number){
            case 3: sb.append(labels[0]);
            case 2: sb.append(labels[0]);
            case 1: sb.append(labels[0]); break;
            case 4: sb.append(labels[0]);
            case 5: sb.append(labels[1]); break;
            case 6: sb.append(labels[1]); sb.append(labels[0]);  break;
            case 7: sb.append(labels[1]); sb.append(labels[0]); sb.append(labels[0]); break;
            case 8: sb.append(labels[1]); sb.append(labels[0]); sb.append(labels[0]); sb.append(labels[0]); break;
            case 9: sb.append(labels[0]); sb.append(labels[2]); break;
            default: {/* do nothing */}
        }

        return sb;
    }

    private void defineLabels(String labels[], int position){
        int i = 0;
        switch(position){
            case 1: {
               labels[i++] = "I";
               labels[i++] = "V";
               labels[i++] = "X";
            }break;
            case 2:{
               labels[i++] = "X";
               labels[i++] = "L";
               labels[i++] = "C";
            }break;
            case 3: {
                labels[i++] = "C";
                labels[i++] = "D";
                labels[i++] = "M";
            }break;
            case 4:{
                labels[i++] = "M";
                labels[i++] = null;
                labels[i++] = null;
            }break;
        }
    }
}
