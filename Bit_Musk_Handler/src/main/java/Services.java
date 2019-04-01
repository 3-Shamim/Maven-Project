import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Services {

    BOOK_SUPER_ADMIN(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.CREATE_BOOK,
                            Operations.READ_BOOK,
                            Operations.UPDATE_BOOK,
                            Operations.DELETE_BOOK,
                            Operations.ISSUE_BOOK
                    )
            )
    ),

    BOOK_ADMIN(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.CREATE_BOOK,
                            Operations.READ_BOOK,
                            Operations.UPDATE_BOOK
                    )
            )
    ),

    BOOK_SUB_ADMIN(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.CREATE_BOOK,
                            Operations.READ_BOOK
                    )
            )
    ),

    BOOK_DEMO_ADMIN(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.CREATE_BOOK,
                            Operations.DELETE_BOOK,
                            Operations.ISSUE_BOOK)
            )
    ),

    BOOK_USER(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.READ_BOOK,
                            Operations.ISSUE_BOOK
                    )
            )
    ),

    BOOK_READ_ONLY(
            new ArrayList<>(
                    Arrays.asList(
                            Operations.READ_BOOK
                    )
            )
    );


    private List<Operations> operations;

    Services(List<Operations> operations) {
        this.operations = operations;
    }

    public List<Operations> getOperations() {
        return operations;
    }
}

