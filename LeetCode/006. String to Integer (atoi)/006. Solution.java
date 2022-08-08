class Solution {
    public int myAtoi(String s) {
        int result = 0;
        boolean isPositive = true;

        State currentState = State.SIGN;

        char c;
        for(int i = 0; i < s.length() && currentState != State.END; i++){
            c = s.charAt(i);
            switch(currentState){
                case SIGN: {
                    if(c == ' ') break;
                    else if(c == '+') { isPositive = true; currentState = State.NUMBER; }
                    else if(c == '-'){ isPositive = false; currentState = State.NUMBER; }
                    else if(c <48 || c > 57) currentState = State.END;
                    else { currentState = State.NUMBER; i--; }
                } break;
                case NUMBER: {
                    if(c < 48 || c > 57){
                        currentState = State.END;
                        break;
                    }

                    int value = c-48;

                    if(isPositive){
                        if(result > (Integer.MAX_VALUE - value) /10){
                            currentState = State.END;
                            result = Integer.MAX_VALUE;
                            break;
                        }

                    }else{
                        if((result*-1) < (Integer.MIN_VALUE + value) / 10){
                            currentState = State.END;
                            result = Integer.MIN_VALUE;
                            break;
                        }
                    }

                    result = result * 10 + value;
                }break;
                default: /* do nothing */
            }
        }

        if(!isPositive) result *= -1;
        return result;

    }

    enum State{
        SIGN,
        NUMBER,
        END
    }
}
