package com.Hosp.navi.domain.enumType;

public enum Position {
    INTERN("인턴"),
    RESIDENT("레지던트"),
    SPECIALIST("전문의"),
    FELLOW("펠로우"),
    PROFESSOR("교수"),
    DEPARTMENT_HEAD("과장"),
    HOSPITAL_DIRECTOR("병원장");

    private final String koreanName;

    Position(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    // 한글을 enum으로 변환
    public static Position changeEnum(String koreanName) {
        for (Position position : Position.values()) {
            if (position.koreanName.equals(koreanName)) {
                return position;
            }
        }
        throw new IllegalStateException("알 수 없는 값 들어옴 : " + koreanName);
    }
}
