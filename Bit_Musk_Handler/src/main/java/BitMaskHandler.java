public class BitMaskHandler {

    public static void main(String[] args) {

        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_READ_ONLY), Services.BOOK_READ_ONLY));
        System.out.println("===================");
        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_USER), Services.BOOK_USER));
        System.out.println("===================");
        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_ADMIN), Services.BOOK_ADMIN));
        System.out.println("===================");
        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_SUB_ADMIN), Services.BOOK_SUB_ADMIN));
        System.out.println("===================");
        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_DEMO_ADMIN), Services.BOOK_DEMO_ADMIN));
        System.out.println("===================");
        System.out.println(parseBitMaskToSingleService(generateBitMaskSingleService(Services.BOOK_SUPER_ADMIN), Services.BOOK_SUPER_ADMIN));


        System.out.println("=================== Fake Bitmask ========");
        System.out.println(parseBitMaskToSingleService( 1321313, Services.BOOK_SUPER_ADMIN));

    }

    public static int generateBitMaskSingleService(Services servicesEnum) {

        int serviceMask = 0;

        serviceMask |= 1 << servicesEnum.ordinal();

        int operationMask = 0;

        for (Operations operations : servicesEnum.getOperations()) {
            operationMask |= 1 << operations.ordinal();
        }

        return ((serviceMask << 16) | operationMask);
    }

    public static boolean parseBitMaskToSingleService(Integer bitmask, Services servicesEnum) {


        int operationMask = 0;

        for (Operations operations : servicesEnum.getOperations()) {
            operationMask |= 1 << operations.ordinal();
        }

        int value = bitmask & operationMask;

        System.out.println(Integer.toBinaryString(value));

        return value == operationMask;
    }

}
