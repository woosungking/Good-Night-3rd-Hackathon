import React, { useEffect, useState } from 'react';
import BackLayout from '../component/wishall/BackLayout';
import NavBar from '../component/NavBar';
import NavBtn from '../component/NavBtn';
import ShowFruit from '../component/wishall/ShowFruits';
import axios from 'axios';
import useWishStore from '../wishstore';
import { useNavigate } from 'react-router-dom';
import useAuthorityStore from '../authoritystore';
import { getAllWish } from '../service/WishService';

const WishTreePage: React.FC = () => {
  const navigate = useNavigate();
  const { wishList, findByWish, setWishList, wishId, setWishId, resetAll } =
    useWishStore();
  const { authority, setAuthority } = useAuthorityStore();
  const [state, setState] = useState<boolean>(false);

  const handleShowWish = async () => {
    const response = await getAllWish();
    setWishList(response);
  };

  const handleTest = () => {
    console.log(findByWish(1));
  };

  const handleClickWish = (id: number) => {
    setWishId(id);
    setState(true);
  };

  const handleModeChange = () => {
    setAuthority();
  };

  const handleRedirect = (url: string) => {
    navigate(url);
  };
  useEffect(() => {
    resetAll();
    handleShowWish();
  }, []);

  useEffect(() => {
    if (state) {
      navigate('/get');
    }
  }, [state, navigate]);

  return (
    <BackLayout>
      <NavBar>
        <div>
          <NavBtn
            buttonText="모드전환"
            addClassName="text-[16px] mr-[5px]"
            onClick={handleModeChange}
          ></NavBtn>
          <NavBtn
            onClick={() => handleRedirect('/add')}
            buttonText="소원열매 달기"
            addClassName="text-[16px]"
          ></NavBtn>
          {authority ? (
            <NavBtn
              onClick={() => handleRedirect('/confirm')}
              buttonText="소원승인"
              addClassName="ml-[5px] text-[16px]"
            ></NavBtn>
          ) : null}
          ;
        </div>
      </NavBar>
      <div className="w-[70%] h-[70%] overflow-y-scroll m-auto flex justify-center flex-wrap">
        {wishList.map((wish) =>
          wish.isConfirmed ? (
            <ShowFruit
              key={wish.wishId}
              wishTitle={wish.title}
              wishId={wish.wishId}
              onClick={handleClickWish}
            />
          ) : null,
        )}
      </div>
      <button onClick={handleTest}>테스트용</button>
    </BackLayout>
  );
};

export default WishTreePage;
