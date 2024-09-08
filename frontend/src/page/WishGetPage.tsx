import React, { useEffect, useState } from 'react';
import BackLayout from '../component/wishget/Backlayout';
import NavBar from '../component/NavBar';
import useWishStore from '../wishstore';
import { GotWish } from '../interface/Wish';
import axios from 'axios';
import { deleteWish, getWish } from '../service/WishService';

const WishGetPage: React.FC = () => {
  const [wish, setWish] = useState<GotWish | undefined>();
  const { wishId } = useWishStore();
  const handleGetWish = async (id: number) => {
    const response = await getWish(id);
    console.log(response);
    setWish(response);
  };
  const handleDeleteWish = async () => {
    const response = await deleteWish(wishId);
  };
  useEffect(() => {
    handleGetWish(wishId);
  }, []);
  return (
    <BackLayout>
      <NavBar></NavBar>
      <div className="m-auto mt-[17vh] w-[30%] h-[50%] relative flex flex-col justify-center">
        <button
          className="absolute right-[40%] top-[0%] w-[100px] h-[50px] bg-red-300 text-[16px]"
          onClick={handleDeleteWish}
        >
          소원성취
        </button>
        {/* 조건부 렌더링으로 undefined 예외 처리 */}
        <p className="text-[32px] font-bold text-center mt-[1vh]">
          {wish?.title}
        </p>
        <p className="text-[16px] text-center mt-[1vh]">{wish?.category}</p>
        <p className="text-[20px] font-bold text-center mt-[1vh]">
          {wish?.content}
        </p>
      </div>
    </BackLayout>
  );
};

export default WishGetPage;
