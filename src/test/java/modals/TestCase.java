package modals;

import lombok.Data;

@Data
public class TestCase {
    String title;
    String section;
    String template;
    String type;
    String priority;
    String estimate;
    String references;
    String automationType;
    String preconditions;
    String steps;
    String expectedResult;

    public TestCase(String title, String section, String template, String type, String priority, String estimate,
                    String references, String automationType, String preconditions, String steps, String expectedResult) {
        this.title = title;
        this.section = section;
        this.template = template;
        this.type = type;
        this.priority = priority;
        this.estimate = estimate;
        this.references = references;
        this.automationType = automationType;
        this.preconditions = preconditions;
        this.steps = steps;
        this.expectedResult = expectedResult;
    }
}