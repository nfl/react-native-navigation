#import <Foundation/Foundation.h>

@interface RNNUtils : NSObject

+(double)getDoubleOrKey:(NSDictionary*)dict withKey:(NSString*)key withDefault:(double)defaultResult;
+(BOOL)getBoolOrKey:(NSDictionary*)dict withKey:(NSString*)key withDefault:(BOOL)defaultResult;
+(id)getObjectOrKey:(NSDictionary*)dict withKey:(NSString*)key withDefault:(id)defaultResult;
@end
