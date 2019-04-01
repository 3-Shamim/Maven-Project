public enum Operations {

    CREATE_BOOK("Create_Book"),
    READ_BOOK("Read_Book"),
    UPDATE_BOOK("Update_Book"),
    DELETE_BOOK("Delete_Book"),
    ISSUE_BOOK("Issue_Book");

    private String name;

    Operations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
