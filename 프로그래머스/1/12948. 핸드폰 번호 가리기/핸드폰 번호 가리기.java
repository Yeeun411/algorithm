class Solution {
    public String solution(String phone_number) {
        // 전화번호의 길이를 구합니다.
        int len = phone_number.length();
        
        // 뒷 4자리를 제외한 나머지를 *로 변경합니다.
        String stars = "*".repeat(len - 4);
        
        // 원래 전화번호의 뒷 4자리를 가져옵니다.
        String lastFourDigits = phone_number.substring(len - 4);
        
        // *로 변경한 문자열과 뒷 4자리를 합쳐서 반환합니다.
        String answer = stars + lastFourDigits;
        return answer;
    }
}
