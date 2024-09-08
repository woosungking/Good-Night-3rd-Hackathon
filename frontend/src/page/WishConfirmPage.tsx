import React, { useEffect, useState } from 'react';
import BackLayout from '../component/BackLayout';
import NavBar from '../component/NavBar';
import NavBtn from '../component/NavBtn';
import WishConfirmList from '../component/wishconfirm/WishConfirmList';
import useWishStore from '../wishstore';
import axios from 'axios';
import { patchWish } from '../service/WishService';

const WishConfirmPage: React.FC = () => {
  const { wishList } = useWishStore(); // wishList를 가져옵니다.
  const [state, setState] = useState<number>(0);

  // 소원을 승인하는 함수
  const handleConfirm = async (id: number, confirm: boolean) => {
    const response = await patchWish(id, confirm);
  };

  useEffect(() => {
    console.log(wishList);
  }, [state]);

  return (
    <BackLayout>
      <NavBar>
        <NavBtn buttonText="소원승인하기" />
      </NavBar>
      <div className="m-auto w-[50%] h-[50%] flex flex-col justify-center">
        <p className="text-[32px] font-bold mb-[2vh]">소원열매 승인</p>
        {wishList
          .filter((wish) => wish.isConfirmed === null) // 필터링 조건을 적용합니다.
          .map((wish) => (
            <WishConfirmList
              key={wish.wishId}
              title={wish.title}
              onDecision={(isConfirmed) =>
                handleConfirm(wish.wishId, isConfirmed)
              } // 승인/거절 결정 핸들러 설정
            />
          ))}
      </div>
    </BackLayout>
  );
};

export default WishConfirmPage;
