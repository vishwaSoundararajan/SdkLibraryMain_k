
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNLibrarysdkSpec.h"

@interface Librarysdk : NSObject <NativeLibrarysdkSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Librarysdk : NSObject <RCTBridgeModule>
#endif

@end
