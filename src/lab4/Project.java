package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Project {
    private String projectName;
    private List<Worker>workerList;

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> list_1) {
        this.workerList = workerList;
    }

    public Project(Builder bld) {
        this.projectName = bld.projectName;
        this.workerList = bld.workerList;
    }

    public static class Builder {

        @Pattern(regexp = "[A-Z][a-zA-Z]+", message = "Project name must start with capital letter")
        private String projectName;
        private List<Worker>workerList;

        public Builder() {
            projectName = "";
            Worker a = new Worker();
            workerList = new ArrayList<Worker>();
            workerList.add(a);
        }

        public Builder withProjectName(String name){
            this.projectName = name;
            return this;
        }

        public Builder withWorkerList(List<Worker> list){
            this.workerList = list;
            return this;
        }

        public void validate(Project projecty) {
            ValidatorFactory fct = Validation.buildDefaultValidatorFactory();
            Validator validator = fct.getValidator();
            Set<ConstraintViolation<Project.Builder>> constraintViolationSet = validator.validate(this);

            String err = new String();
            err = "";

            for (var cv : constraintViolationSet) {
                err += "Error on (" + cv.getInvalidValue() + ") with message: " + cv.getMessage() + "\n";
            }

            if (err != "") {
                throw new IllegalArgumentException(err);
            }
        }

        public Project build() {
            Project project = new Project(this);
            validate(project);
            return project;
        }

    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", workerList=" + workerList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName) && workerList.equals(project.workerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, workerList);
    }
}
