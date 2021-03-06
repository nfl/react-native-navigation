#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import "RNNStore.h"

@interface RNNNavigationStackManager : NSObject

@property (nonatomic, strong) UIViewController* fromVC;
@property (nonatomic, strong) RNNRootViewController* toVC;
@property (nonatomic) int loadCount;
-(instancetype)initWithStore:(RNNStore*)store;


-(void)push:(UIViewController<RNNRootViewProtocol>*)newTop onTop:(NSString*)componentId completion:(RNNTransitionCompletionBlock)completion;
-(void)pop:(NSString*)componentId withTransitionOptions:(RNNAnimationOptions*)transitionOptions;
-(void)popTo:(NSString*)componentId;
-(void)popToRoot:(NSString*)componentId;
-(void)setRoot:(UIViewController<RNNRootViewProtocol> *)newRoot fromComponent:(NSString *)componentId completion:(RNNTransitionCompletionBlock)completion;

@end
